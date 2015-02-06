import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;

public class ServerThread extends Thread {

    private PrintStream os;
    private BufferedReader is;
    private InetAddress addr;

    public ServerThread(Socket socket) throws IOException{
        os = new PrintStream(socket.getOutputStream());
        is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        addr = socket.getInetAddress();
    }

    public void run(){
        int i = 0;
        String str;

        try {
            while ((str = is.readLine()) != null){
                if ("PING".equals(str)){
                   os.println("PONG" + ++i);
                }
                System.out.println("PING-PONG" +i +" with " +addr.getHostAddress());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            disconect();
        }
    }

    private void disconect() {
        if (os != null){
            os.close();
        }
        if (is != null){
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                this.interrupt();
            }
        }
    }
}
