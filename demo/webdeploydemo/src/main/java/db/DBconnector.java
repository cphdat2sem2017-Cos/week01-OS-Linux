package db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Thomas Hartmann - tha@cphbusiness.dk created on Feb 1, 2017 
 */
public class DBconnector {


    private final static String HOST     = "95.85.42.202";
    private final static int    PORT     = 3306;
    private final static String DATABASE = "test";
    private final static String USERNAME = "remoteuser"; 
    private final static String PASSWORD = "Cphbus2017hemlinemli";
    private static Connection connection = null;
    
    
    public static Connection getConnector() throws SQLException, ClassNotFoundException{
        if (connection == null) {
            Class.forName("com.mysql.jdbc.Driver");
            String url = String.format("jdbc:mysql://%s:%s/%s", HOST, PORT, DATABASE);
            return DriverManager.getConnection(url, USERNAME, PASSWORD);
        }
        return connection;
    }
//    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        new DBconnector();
//    }
//    public ResultSet doQuery(String query) throws SQLException, ClassNotFoundException{
//        System.out.println("*********"+query);
//        Statement stmt = getConnector().createStatement();
//        ResultSet res = stmt.executeQuery(query);
//        return res;
//    }
//    
//    public void doUpdate(String query) throws SQLException, ClassNotFoundException{
//        Statement stmt = getConnector().createStatement();
//        stmt.executeUpdate(query);
//    }
//    
    public static PreparedStatement getPreparedStatement(String sql) throws SQLException, ClassNotFoundException{
        return getConnector().prepareStatement(sql);
    }
}
