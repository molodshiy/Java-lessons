import UnitJDBS.Ex1DriverManager.Abonent;
import UnitJDBS.Ex1DriverManager.ConnectorDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataBaseHelper {

    private static  final String SQL_Insert = "INSERT INTO phonebook(idphonebook, lastname, phone) VALUES(?, ?, ?);";

    private Connection connect;

    public DataBaseHelper () throws SQLException {
        connect = ConnectorDB.getConnection();
    }

    public PreparedStatement getPreparedStatement(){
     PreparedStatement ps = null;
        try{
            ps = connect.prepareStatement(SQL_Insert);
        } catch (SQLException e){
         e.printStackTrace();
        }
        return ps;
    }

    public boolean insertAbonent(PreparedStatement ps, Abonent ab) {
        boolean flag = false;
        try {
            ps.setInt(1, ab.getId());
            ps.setString(2, ab.getLastname());
            ps.setInt(3, ab.getPhone());
            ps.executeUpdate();
            flag = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }
    public void closeStatement(PreparedStatement ps) {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
