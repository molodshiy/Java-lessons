import java.io.File;
import java.util.Date;

public class ExFile {
    public static void main(String[] args) {

        File file = new File("C:\\ttr\\text.txt");

        System.out.println("File exists: " +file.exists());
        System.out.println("Length file is: " +file.length());
        System.out.println("If file is file: " +file.isFile());
        System.out.println("AbsolutePath: " +file.getAbsolutePath());
        System.out.println("Last Modifire is: " +new Date(file.lastModified()));
        System.out.println("If file can read: " +file.canRead());
    }
}
