import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RadeAzrr {
    private File  file;

    public void RadeAzrr(File file){
        this.file=file;
    }

    public static String[] file2StringArray(File file) {
        BufferedReader br = null;
        List<String> list = new ArrayList<String>();
        try {
            br = new BufferedReader(new FileReader(file));
            String str = null;
            while ((str = br.readLine()) != null) {
                list.add(str);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list.toArray(new String[0]);
    }
}
