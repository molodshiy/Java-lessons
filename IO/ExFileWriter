import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class ExFileWriter {
    public static void main(String[] args) {

        String s = "Text for Streams";

        File file1 = new File("C:\\ttr\\text1.txt");
        File file2 = new File("C:\\ttr\\text2.txt");

        FileWriter fw = null;
        FileOutputStream fos = null;

        try{
            fos = new FileOutputStream(file2);
            fw = new FileWriter(file1);

            fos.write(s.getBytes());
            fw.write(s);
        }
        catch(IOException e){
            e.printStackTrace();
        }
        finally {
            try {
                fw.close();
            }
            catch (IOException e) {
                System.out.println("Error in close FileInputStream");
            }
        }
    }
}
