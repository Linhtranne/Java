package businness.dao.pesion;

public interface AccountDao {
    int login(String username, String password);
    void logout();
}
