import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetLogic {
    public static void main(String[] args) {
        InetAddress currentIP = null;
        InetAddress googleIP = null;
        try {
            currentIP = InetAddress.getLocalHost();
            System.out.println("Current IP: " +currentIP.getHostAddress());
            googleIP = InetAddress.getByName("www.google.com.ua");
            System.out.println("google IP: " +googleIP.getHostAddress());
        } catch (UnknownHostException e) {
            System.out.println("Addres not found " +e);
        }
    }
}
