import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class NetServerThread {
    public static void main(String[] args) {

        try {
            ServerSocket server = new ServerSocket(8080);
            System.out.println("initialized");

            while (true){
                Socket socket = server.accept();
                System.out.println(socket.getInetAddress() +" connected!!!");

                ServerThread thread = new ServerThread(socket);
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
