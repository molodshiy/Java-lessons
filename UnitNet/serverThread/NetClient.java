import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class NetClient {
    public static void main(String[] args) {

        Socket socket = null;
        BufferedReader br = null;

        try {
            socket = new Socket("127.0.0.1", 8080);
            PrintStream ps = new PrintStream(socket.getOutputStream());
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            for (int i = 0; i < 10; i++) {
                ps.println("PING");
                System.out.println(br.readLine());
                Thread.sleep(1_000);
            }

        } catch (UnknownHostException e) {
            System.out.println("Cant connect to address" +e);
        } catch (IOException e) {
            System.out.println("Error in IO Thread" +e);
        } catch (InterruptedException e) {
            System.out.println("Error in runtime" +e);
        } finally {
            if (br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
