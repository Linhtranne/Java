package businness.service.account;


import businness.dao.pesion.AccountDao;
import businness.dao.pesion.AccountDaoImp;

public class AccountSeviceImp implements AccountSevice {
    private final AccountDao accountDao = new AccountDaoImp();
    @Override
    public int login(String username, String password) {
        return accountDao.login(username, password);
    }
    @Override
    public void logout() {
        accountDao.logout();
    }
}
