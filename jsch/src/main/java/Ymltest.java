import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class Ymltest {

        public static void updateyml() {//
            String path ="./resources/prometheus.yml";
            String file_ip = "./resources/node_ip.txt";
            File file = new File(file_ip);
            String[] strs = RadeAzrr.file2StringArray(file);

            try {
                FileWriter fw = new FileWriter(path,false);
                fw.write("global:"+" #配置全局信息");
                fw.write("\n  scrape_interval: 15s");
                fw.write("\n  evaluation_interval: 15s");
                fw.write("\nalerting:"+" #配置預警信息");
                fw.write("\n alertmanagers:");
                fw.write("\n  - static_configs:");
                fw.write("\n    - targets:");
                fw.write("\nrule_files:"+" #配置抓取規則");
                fw.write("\nscrape_configs:"+" #配置監控信息");
                fw.write("\n  - job_name: node");
                fw.write("\n    static_configs:");
                fw.write("\n    - targets: [");
                for(String str: strs) {
                    String[] st = str.split("#");
                    StringBuffer targets = new StringBuffer();
                    targets.append("'").append(st[0]).append(":9100',");
                    fw.write(""+targets.toString());
                }
                fw.write("]");
                fw.write("\n      labels:");
                fw.write("\n          instance: node");
                fw.write("\nremote_write:"+" #写入influxdb");
                fw.write("\n  - url: \"http://localhost:9201/write\"");
                fw.write("\n    basic_auth:");
                fw.write("\n      username: node");
                fw.write("\n      password: node");
                fw.write("\nremote_read:"+" #读出influxdb");
                fw.write("\n  - url: \"http://localhost:9201/read\"");
                fw.write("\n    basic_auth:");
                fw.write("\n      username: node");
                fw.write("\n      password: node");
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

}
