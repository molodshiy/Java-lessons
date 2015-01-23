import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExFileReader {
    
    public static void main (String [] args) {

        String path = "C:\\ttr\\text.txt";

        File file = new File(path);
        int count = 0, b;
        
        /*You also can use FileReader instead FileInputStream*/
        FileInputStream fis = null;

        try {
             fis = new FileInputStream(file);

            while((b = fis.read()) != -1){
                System.out.print((char) b);
                count++;
            }
            System.out.println("\n The number of bytes = " +count);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try{
                if (fis != null)
                    fis.close();
            }
            catch(IOException e){
                System.out.println("Error in close FileInputStream");
            }
        }
    }
}
