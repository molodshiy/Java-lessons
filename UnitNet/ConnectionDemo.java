import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class ConnectionDemo {
    public static void main(String[] args) {

        String urlName = "https://www.google.com.ua";
        URL url;
        int timeout = 10_000_000;

        try {
            url = new URL(urlName);
            final URLConnection connection = url.openConnection();
            connection.setConnectTimeout(timeout);

            System.out.println(urlName +" connect type: " +connection.getContentType());

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
