import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SmallServerSocket {
    public static void main(String[] args) {

        Socket socket = null;
        PrintStream ps = null;

        try {
            ServerSocket server = new ServerSocket(8030);
            socket = server.accept();
            ps = new PrintStream(socket.getOutputStream());
            ps.println("HI people!!!");
            ps.flush();                     //send to Client
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ps != null){
                ps.close();
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
