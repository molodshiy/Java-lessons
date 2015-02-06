import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class UnCheckedHost {
    public static void main(String[] args) {

        byte ip [] = {74, 125, 71, 94};

        try {
            InetAddress addr = InetAddress.getByAddress(ip);
            System.out.println(addr.getHostAddress() +"-> connect: " +addr.isReachable(1000));

        } catch (UnknownHostException e) {
            System.out.println("Unknown Host!!!" +e);
        } catch (IOException e) {
            System.out.println("Error in thread!!!" +e);
        }
    }
}
