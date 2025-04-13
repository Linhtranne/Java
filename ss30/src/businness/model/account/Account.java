package businness.model.account;

public class Account {
    private String Username;
    private String Password;
    private AccountStatus Status;

    public Account(String username, String password, AccountStatus status) {
        Username = username;
        Password = password;
        Status = status;
    }
    public Account(){

    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public AccountStatus getStatus() {
        return Status;
    }

    public void setStatus(AccountStatus status) {
        Status = status;
    }

    @Override
    public String toString() {
        return "Account" +
                "Tên đăng nhập'" + Username + '\'' +
                ", Mật khẩu'" + Password + '\''
                ;
    }
}
