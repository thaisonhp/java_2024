package controller.Impl;

import controller.AuthService;
import model.Account;
import model.Role;
import model.Status;

import java.util.Scanner;

public class AuthServiceImpl implements AuthService {
    private Account currentAccount ;

    public AuthServiceImpl() {
        Account.getAccounts().add(new Account("admin","admin123", Role.ADMIN , Status.ACTIVE));
        Account.getAccounts().add(new Account("user","user123", Role.USER, Status.ACTIVE));
    }



    @Override
    public boolean login(Scanner scanner) {
        System.out.println("====== Màn hình đăng nhập =======");
        System.out.print("Enter UserName: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        for(Account ac : Account.getAccounts()){
            if(ac.getUsername().equals(username) && ac.getPassword().equals(password)){
                currentAccount = ac ;
                System.out.println("Login successfully!");
                return true;
            }
        }
        System.out.println("Login failed!");
        scanner.close();
        return false;
    }

    @Override
    public boolean logout() {
        if(currentAccount != null) {
            currentAccount = null;
            System.out.println("Logout successfully!");
            return true;
        } else {
            System.out.println("No user is currently logged in!");
            return false;
        }
    }

    @Override
    public void changePassword(String username, String oldPassword, String newPassword) {
        for(Account ac : Account.getAccounts()){
            if(ac.getUsername().equals(username) && ac.getPassword().equals(oldPassword)){
                ac.setPassword(newPassword);
            }
            System.out.println("Change password successfully!");
        }
    }

    @Override
    public boolean checkAdmin() {
        return currentAccount != null && currentAccount.getRole() == Role.ADMIN;
    }

    public Account getCurrentAccount() {
        return currentAccount;
    }

    public void setCurrentAccount(Account currentAccount) {
        this.currentAccount = currentAccount;
    }
}
