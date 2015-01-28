import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        Resourse rs = null;

        try {

            rs = new Resourse("C:\\ttr\\syncText.txt");

            SyncThreaad st1 = new SyncThreaad("First", rs);
            SyncThreaad st2 = new SyncThreaad("Second", rs);

            st1.start();
            st2.start();

            st1.join();
            st2.join();

            rs.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
