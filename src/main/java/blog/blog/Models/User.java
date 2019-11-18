package blog.blog.Models;

public class User {

    private int userId;
    private String username;
    private String password;
    private String privs;

    public User() {
    }

    public User(int userId, String username, String password, String privs) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.privs = privs;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public String getPrivs() {
        return privs;
    }

    public void setPrivs(String privs) {
        this.privs = privs;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", privs='" + privs + '\'' +
                '}';
    }
}
