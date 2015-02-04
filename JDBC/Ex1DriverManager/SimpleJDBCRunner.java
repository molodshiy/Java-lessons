import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class SimpleJDBCRunner {
    public static void main(String[ ] args) throws SQLException {

        String url = "jdbc:mysql://localhost:3306/testphones";
        Properties prop = new Properties();
        prop.put("user", "root");
        prop.put("password", "root");
        prop.put("autoReconnect", "true");
        prop.put("characterEncoding", "UTF-8");
        prop.put("useUnicode", "true");

        Connection cn = null;

        DriverManager.registerDriver(new com.mysql.jdbc.Driver());

        try { // 1
            cn = DriverManager.getConnection(url, prop);
            Statement st = null;
            try { // 2
                st = cn.createStatement();
                ResultSet rs = null;
                try { // 3
                    rs = st.executeQuery("SELECT * FROM phonebook");
                    ArrayList<Abonent> lst = new ArrayList<>();
                    while (rs.next()) {
                        int id = rs.getInt(1);
                        int phone = rs.getInt(3);
                        String name = rs.getString(2);
                        lst.add(new Abonent(id, phone, name));
                    }
                    if (lst.size() > 0) {
                        System.out.println(lst);
                    } else {
                        System.out.println("Not found");
                    }
                } finally {
/*
* close ResultSet
*/
                    if (rs != null) {
                        rs.close();
                    } else {
                        System.err.println(
                                "Error with database!");
                    }
                }
            } finally {
/*
* close Statement
*/
                if (st != null) { // for 2
                    st.close();
                } else {
                    System.err.println("Statement did not create!");
                }
            }

        } catch (SQLException e) { // for 1
            System.err.println("DB connection error: " + e);

        } finally {
/*
* close Connection, if Connection is open
*/
            if (cn != null) {
                try {
                    cn.close();
                } catch (SQLException e) {
                    System.err.println("Сonnection close error: " + e);
                }
            }
        }
    }
}
