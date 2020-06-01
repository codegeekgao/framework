import java.io.File;



public class deploy {
    public static void deploy_node() {
        String file_ip = "./resources/node_ip.txt";
        String file_node = "./resources/node_export64.tar.gz";
        String file_startup = "./resources/node_startup.sh";
        File file = new File(file_ip);
        String[] strs = RadeAzrr.file2StringArray(file);
        for(String str: strs){
            String[] st = str.split("#");
            jsch jSchUtil = new jsch( st[1], st[2],st[0]);
            try {
                //连接服务器
                jSchUtil.connect();
                //上傳文件
                jSchUtil.uploadFile(file_node,"/root/node_export64.tar.gz");
                jSchUtil.uploadFile(file_startup,"/root/node_startup.sh");
                //執行命令
                jSchUtil.execCmd("chmod 777 node_startup.sh");
                jSchUtil.execCmd("./node_startup.sh /dev/null 2>&1");
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                jSchUtil.disconnect();
            }
        }
    }

    public static void deploy_pg() {
        Ymltest.updateyml();
        String filepg_ip = "./resources/pgrf_ip.txt";
        String file_g = "./resources/grafana-5.2.1.linux-amd64.tar.gz";
        String file_p = "./resources/prometheus-2.17.1.linux-amd64.tar.gz";
        String file_fldb = "./resources/influxdb-1.8.0_linux_amd64.tar.gz";
        String file_rsa = "./resources/remote_storage_adapter";
        String g_startup = "./resources/all_tar.sh";
        String all_startup = "./resources/all_startup.sh";
        String p_config = "./resources/prometheus.yml";

        File file = new File(filepg_ip);
        String[] strs = RadeAzrr.file2StringArray(file);
        for(String str: strs){
            String[] st = str.split("#");
            jsch jSchUtil = new jsch( st[1], st[2],st[0]);
            try {
                //连接服务器
                jSchUtil.connect();
                //上传文件
//                jSchUtil.uploadFile(file_g,"/root/grafana-5.2.1.linux-amd64.tar.gz");
//                jSchUtil.uploadFile(file_p,"/root/prometheus-2.17.1.linux-amd64.tar.gz");
//                jSchUtil.uploadFile(file_fldb,"/root/influxdb-1.8.0_linux_amd64.tar.gz");
//                jSchUtil.uploadFile(file_rsa,"/root/remote_storage_adapter");
//                jSchUtil.uploadFile(g_startup,"/root/all_tar.sh");
//                jSchUtil.uploadFile(all_startup,"/root/all_startup.sh");
//                jSchUtil.uploadFile(p_config,"/root/prometheus.yml");
//                //执行命令
//                jSchUtil.execCmd("chmod 777 all_startup.sh remote_storage_adapter all_tar.sh");
//                jSchUtil.execCmd("./all_tar.sh /dev/null 2>&1");
                jSchUtil.execCmd("cd");
                jSchUtil.execCmd("./start.sh");

            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                jSchUtil.disconnect();
            }
        }
    }
}
