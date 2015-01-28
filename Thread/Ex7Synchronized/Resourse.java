import java.io.FileWriter;
import java.io.IOException;

public class Resourse {

    private FileWriter fileWriter;

    public Resourse(String file) throws IOException {
        fileWriter = new FileWriter(file, true);
    }

    public synchronized void writing(String str, int i){
        try {
            fileWriter.append(str  +i);
            System.out.println(str +i);

                Thread.sleep((long)(Math.random()*50));
            fileWriter.append("=>" +i +" ");
            System.out.println("=>" +i +" ");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void close(){
        try {
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
