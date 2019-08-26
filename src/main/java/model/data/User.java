package model.data;

public class User {
    private int userId;
    private String username;
    private Account account;

    public User() {

    }

    public User(int userId, String username, Account account) {
        this.userId = userId;
        this.username = username;
        this.account = account;
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

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", account=" + account +
                '}';
    }
}
