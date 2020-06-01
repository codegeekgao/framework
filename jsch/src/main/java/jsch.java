//import com.bluemoon.executor.core.log.XxlJobLogger;

import com.jcraft.jsch.*;

import java.io.*;
import java.nio.charset.Charset;

import static java.lang.Thread.sleep;

//import org.slf4j.LoggerFactory;

public class jsch {
   // private static Logger log = LoggerFactory.getLogger(JSchExecutor.class);
    private String charset = "UTF-8"; // 设置编码格式
    private String user; // 用户名
    private String passwd; // 登录密码
    private String host; // 主机IP
    private int port = 22; //默认端口
    private JSch jsch;
    private Session session;

    private ChannelSftp sftp;

    /**
     *
     * @param user 用户名
     * @param passwd 密码
     * @param host 主机IP
     */
    public jsch(String user, String passwd, String host ) {
        this.user = user;
        this.passwd = passwd;
        this.host = host;
    }

    /**
     *
     * @param user 用户名
     * @param passwd 密码
     * @param host 主机IP
     */
    public jsch(String user, String passwd, String host , int port ) {
        this.user = user;
        this.passwd = passwd;
        this.host = host;
        this.port = port;
    }

    /**
     * 连接到指定的IP
     *
     * @throws JSchException
     */
    public void connect() throws JSchException {
        jsch = new JSch();
        session = jsch.getSession(user, host, port);
        session.setPassword(passwd);
        java.util.Properties config = new java.util.Properties();
        config.put("StrictHostKeyChecking", "no");
        session.setConfig(config);
        session.connect();
        Channel channel = session.openChannel("sftp");
        channel.connect();
        sftp = (ChannelSftp) channel;
        //log.info("连接到SFTP成功。host: " + host);
        System.out.println("成功连接到服务器，HOST:"+host);
    }
    /**
     * 关闭连接
     */
    public void disconnect(){
        if (sftp != null && sftp.isConnected()) {
            sftp.disconnect();
        }
        if(session != null && session.isConnected()){
            session.disconnect();
        }
    }

    /**
     * 执行相关的命令
     * @param ls
     */
    public void execCmd(String ls) {

        String command = ls;
        BufferedReader reader = null;
        Channel channel = null;

        try {
            if  (command != null) {
                channel = session.openChannel("exec");
                ((ChannelExec) channel).setCommand(command);
                channel.setInputStream(null);
                ((ChannelExec) channel).setErrStream(System.err);

                channel.connect();
                sleep(5000);
                InputStream in = channel.getInputStream();
                reader = new BufferedReader(new InputStreamReader(in,Charset.forName(charset)));
            }else{
                System.out.println("请输入命令......");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSchException e) {
            e.printStackTrace();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception en) {
            en.printStackTrace();
        }
        finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            channel.disconnect();
        }
    }

    /**
     * 上传文件
     */
    public void uploadFile(String local,String remote) throws Exception {
        File file = new File(local);
        if (file.isDirectory()) {
            throw new RuntimeException(local + "  is not a file");
        }

        InputStream inputStream = null;
        try {
            String rpath = remote.substring(0,remote.lastIndexOf("/")+1);
            if (!isDirExist(rpath)){
                createDir(rpath);
            }
            inputStream = new FileInputStream(file);
            sftp.setInputStream(inputStream);
            sftp.put(inputStream, remote);
        } catch (Exception e) {
            throw e;
        }finally{
            if(inputStream != null){
                inputStream.close();
            }
        }
    }
    /**
     * 下载文件
     */
    public void downloadFile(String remote,String local) throws Exception{
        OutputStream outputStream = null;
        try {
            sftp.connect(5000);
            outputStream = new FileOutputStream(new File(local));
            sftp.get(remote, outputStream);
            outputStream.flush();
        } catch (Exception e) {
            throw e;
        }finally{
            if(outputStream != null){
                outputStream.close();
            }
        }
    }

    /**
     * 创建一个文件目录，mkdir每次只能创建一个文件目录
     * 或者可以使用命令mkdir -p 来创建多个文件目录
     */
    public void createDir(String createpath) {
        try {
            if (isDirExist(createpath)) {
                sftp.cd(createpath);
                return;
            }
            String pathArry[] = createpath.split("/");
            StringBuffer filePath = new StringBuffer("/");
            for (String path : pathArry) {
                if (path.equals("")) {
                    continue;
                }
                filePath.append(path + "/");
                if (isDirExist(filePath.toString())) {
                    sftp.cd(filePath.toString());
                } else {
                    // 建立目录
                    sftp.mkdir(filePath.toString());
                    // 进入并设置为当前目录
                    sftp.cd(filePath.toString());
                }
            }
            sftp.cd(createpath);
        } catch (SftpException e) {
            throw new RuntimeException("创建路径错误：" + createpath);
        }
    }
    /**
     * 判断目录是否存在
     * @param directory
     * @return
     */
    public boolean isDirExist(String directory)
    {
        boolean isDirExistFlag = false;
        try
        {
            SftpATTRS sftpATTRS = sftp.lstat(directory);
            isDirExistFlag = true;
            return sftpATTRS.isDir();
        }
        catch (Exception e)
        {
            if (e.getMessage().toLowerCase().equals("no such file"))
            {
                isDirExistFlag = false;
            }
        }
        return isDirExistFlag;
    }


}