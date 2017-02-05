package db;

import entity.User;
import exceptions.ToLogException;
import exceptions.UserFeedbackException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Thomas Hartmann - tha@cphbusiness.dk created on Feb 1, 2017 
 */
public class UserMapper {
    
    public User getUser(int id) throws Exception{
        String sql = "SELECT id, created, username, password FROM myusers WHERE id = ?";
        try {
            PreparedStatement pstmt = DBconnector.getPreparedStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                return new User(id, rs.getString("username"), rs.getString("password"), rs.getDate("created"));
            }     
        } catch (SQLException | ClassNotFoundException ex) {
            throw new ToLogException("Error in getUser()"+ex.getMessage());
        }
        throw new Exception("No user by that ID");
    }
    public void addUser(String username, String password) throws ToLogException {
        try {
            String sql = "INSERT INTO myusers (username, password) VALUES (?,?)";
            PreparedStatement pstmt = DBconnector.getPreparedStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.executeUpdate();
                
        } catch (SQLException | ClassNotFoundException ex) {
            throw new ToLogException("Error in addUser(): "+ex.getMessage());
        }
    }
    public String verifyUser(String username, String password) throws ToLogException, UserFeedbackException{
        try{
            String sql = "SELECT id, username, password, created FROM myusers WHERE username = ? AND password = ?";
            PreparedStatement pstmt = DBconnector.getPreparedStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                return username;
            }
        }catch (SQLException | ClassNotFoundException ex) {
            throw new ToLogException("Error in verifyUser(): "+ex.getMessage());
        }
        throw new UserFeedbackException("Username or password did not match");
    }
    public List<User> getUsers() throws ToLogException{
        List<User> users = new ArrayList();
        try{
            String sql = "SELECT id, username, password, created FROM myusers";
            PreparedStatement pstmt = DBconnector.getPreparedStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                User u = new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"), rs.getDate("created"));
                users.add(u);
            }
            return users;
        }catch (SQLException | ClassNotFoundException ex) {
            throw new ToLogException("Error in getAllUsers(): "+ex.getMessage());
        }
    }
    public void deleteUsers() throws ToLogException{
        try {
            String sql = "TRUNCATE TABLE myusers";
            DBconnector.getPreparedStatement(sql).executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            throw new ToLogException("Error in getAllUsers(): "+ex.getMessage());
        }
    }
    public static void main(String[] args) throws UserFeedbackException, ToLogException  {
        UserMapper um = new UserMapper();
        um.deleteUsers();
        um.addUser("Hans", "hans123");
        um.addUser("Grethe", "grethe123");
        um.addUser("Philip", "phil123");
        List<User> users = um.getUsers();
        users.stream().forEach((u)->System.out.println(u.getUsername()+":"+u.getPassword()));
    }
}
