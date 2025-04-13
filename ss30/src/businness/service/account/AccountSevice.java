package businness.service.account;

import businness.service.AppSevice;

public interface AccountSevice extends AppSevice {
    int login(String username, String password); // return loginResult
    void logout();
}
