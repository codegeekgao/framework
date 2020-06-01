import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class redewYml {
        //写入yaml配置文件


    public static class yaml {
        public static void mainred(String[] args) {
            try {
                Map m1,m2,m3,m4,m5;
                FileWriter fw;

	    /* 读取 */
                Yaml y = new Yaml();
	    //创建file对象
                File file = new File("./resources/prometheus1.yml");
	    //将yaml内容解析成map表
                m1 = (Map) y.load(new FileInputStream(file));
	    //获取第一级键中的“details”键作为对象，进一步获取下级的键和值
                m2 = (Map) m1.get("job_name");
                //m3 = (Map) m2.get("job_name");
                //m4 = (Map) m2.get("targets");
                //m5 = (Map) m4.get("targets");
        //这里email键属于第三级，对其key进行赋值
                m2.put("-job_name", "'node1'");
	    //将第四级键“tel”赋值2222
               // m4.put("targets", "['172.31.25.231:9090']");

	    /* 写入 */
	    //初始化filewriter对象，用于写入操作
                fw = new FileWriter(file);
	    //用snakeyaml的dump方法将map类解析成yaml内容
                fw.write(y.dump(m1));
	    //写入到文件中
                fw.flush();
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
