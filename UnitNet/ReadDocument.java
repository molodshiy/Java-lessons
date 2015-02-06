import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class ReadDocument {
    public static void main(String[] args) {
        URL google = null;
        String urlName = "http://www.google.com.ua";

        try {
            google = new URL(urlName);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        if (google == null){
            throw new RuntimeException();
        }
        try (
            BufferedReader d = new BufferedReader(new InputStreamReader(google.openStream()))){
            String line = "";
            while((line = d.readLine()) != null){
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
