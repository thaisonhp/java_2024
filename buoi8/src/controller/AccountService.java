package controller;
import model.*;
import java.util.* ;
public interface AccountService {
    public List<Account> getAllAccount();
    void createNewAccount(Account account);
    Account getAccountByUsername(String username);
    void deleteAccount(String username);
    void changeStatus(String username, Status status);
}
