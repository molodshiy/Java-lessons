package UnitJDBS.Ex3Transaction;

import java.sql.*;

public class SingletonEngine {

    private static SingletonEngine instance = null;

    public synchronized static SingletonEngine getInstance(){
        if (instance == null){
            instance = new SingletonEngine();
        }
       return instance;
    }

    private  Connection getConnectionFrom(){

        Connection connectionFrom = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            String url = "jdbc:mysql://localhost:3306/test_From";
            connectionFrom = DriverManager.getConnection(url, "root", "root");
            connectionFrom.setAutoCommit(false);
        } catch (SQLException e) {
            System.out.println("SQLException: " +e.getMessage() +"SQLState: " +e.getSQLState());
        } catch (ClassNotFoundException e){
            System.out.println("Driver not found!!!");
        }
        return connectionFrom;
    }

    private Connection getConnectionTo(){

        Connection connectionTo = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            connectionTo = DriverManager.getConnection("jdbc:mysql://localhost:3306/testTo", "root", "root");
            connectionTo.setAutoCommit(false);
        } catch (SQLException e) {
            System.out.println("SQLException: " +e.getMessage() +"SQLStste: " +e.getSQLState());
        } catch (ClassNotFoundException e){
            System.out.println("Driver not found!!!");
        }
        return connectionTo;
    }

    public void transfer(String summa) throws SQLException {
        Statement stFrom = null;
        Statement stTo = null;
        Connection connectionFrom = getConnectionFrom();
        Connection connectionTo = getConnectionTo();
        try {
            int sum = Integer.parseInt(summa);
            if (sum <= 0){
                throw new NumberFormatException("less or equels zero!!!");
            }

            stFrom = connectionFrom.createStatement();
            stTo = connectionTo.createStatement();

            ResultSet rsFrom = stFrom.executeQuery("SELECT balance from table_from");
            ResultSet rsTo = stTo.executeQuery("SELECT balance from table_to");

            int acountFrom = 0;

            while (rsFrom.next()){
                acountFrom = rsFrom.getInt(1);
            }

            int resultFrom = 0;
            if (acountFrom >= sum){
                resultFrom = acountFrom - sum;
            } else {
                throw new SQLException("Invalid balance!!!");
            }

            int acountTo = 0;
            while (rsTo.next()){
                acountTo = rsTo.getInt(1);
            }

            int resultTo = acountTo + sum;

            stFrom.executeUpdate("UPDATE table_from SET balance=" +resultFrom);
            stTo.executeUpdate("UPDATE table_to SET balance=" +resultTo);

            connectionFrom.commit();
            connectionTo.commit();
            
            System.out.println("remaining on :" +resultFrom +" rub");
            
        } catch (SQLException e) {
            System.err.println("SQLState" +e.getSQLState() +"Error Message" +e.getMessage());
            connectionFrom.rollback();
            connectionTo.rollback();
        } catch (NumberFormatException e){
            System.err.println("Invalid summa: " + summa);
        } finally {
            if(stFrom != null){
                try {
                    stFrom.close();
                } catch (SQLException ex){
                    ex.printStackTrace();
                }
            }
        }

        if (stTo != null){
            stTo.close();
        }
    }
}
