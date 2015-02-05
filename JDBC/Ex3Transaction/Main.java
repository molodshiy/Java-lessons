import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        SingletonEngine singletonEngine = new SingletonEngine().getInstance();
        
        try {
            singletonEngine.transfer("10");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
