import com.jcraft.jsch.JSchException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestStart {

    public static void main(String[] args) throws IOException, JSchException {
        InputStream resourceAsStream = TestStart.class.getClassLoader().getResourceAsStream("deploy.properties");
        Properties properties = new Properties();
        properties.load(resourceAsStream);
        jsch jsch = new jsch(properties.getProperty("username"),properties.getProperty("password"),properties.getProperty("ip"));
        jsch.connect();
        jsch.execCmd("cd");
        jsch.execCmd("./start.sh");
    }
}
