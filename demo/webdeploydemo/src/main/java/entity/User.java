package entity;

import java.util.Date;

/**
 *
 * @author Thomas Hartmann - tha@cphbusiness.dk created on Feb 1, 2017 
 */
public class User {
    private int id;
    private String username;
    private String password;
    private Date created;
    
    public User() {
    }

    public User(int id, String username, String password, Date created) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.created = created;
    }

    public User(String username, String password, Date created) {
        this.username = username;
        this.password = password;
        this.created = created;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
    
}
