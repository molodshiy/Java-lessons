import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketTimeoutException;

public class UDPRecipient {
    public static void main(String[] args) {
        File file = new File("F:\\Films\\Friends.in2.txt");
        System.out.println("...");

        acceptFile(file, 8033, 1024);
    }
    private static void acceptFile(File file, int port, int pacSize) {
        byte data[] = new byte[pacSize];
        DatagramPacket pac = new DatagramPacket(data, data.length);
        try (FileOutputStream os = new FileOutputStream(file)) {
            DatagramSocket s = new DatagramSocket(port);

            s.setSoTimeout(60_000);
            while (true) {
                s.receive(pac);
                os.write(data);
                os.flush();
            }
        } catch (SocketTimeoutException e) {

            System.err.println("");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
