package entity;

public class User {
    protected int userId;
    protected String username;
    protected String password;
    public User(int userId, String username, String password) {
        this.userId=userId;
        this.username = username;
        this.password = password;
    }
    public User(){

    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}