package controller.Impl;

import controller.AccountService;
import model.Account;
import model.Address;
import model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AccountServiceImpl implements AccountService {
    @Override
    public List<Account> getAllAccount() {
        List<Account> accounts = Account.getAccounts();
        return accounts;
    }

    @Override
    public void createNewAccount(Account account) {
        Account.getAccounts().add(account);
    }

    @Override
    public Account getAccountByUsername(String username) {
        for(Account account : Account.getAccounts()) {
            if(account.getUsername().equals(username)) {
                System.out.println(account);
                System.out.println("Lay nguoi dung thanh cong");
                return account;
            }
        }
        System.out.println("Lay nguoi dung that bai");
        return null;
    }

    @Override
    public void deleteAccount(String username) {
        ArrayList<Account> accounts = Account.getAccounts();
        for (Account account : Account.getAccounts()) {
            if(account.getUsername().equals(username)) {
                System.out.println("xoa thang cong");
                accounts.remove(account);
            }
        }
        Account.setAccounts(accounts);
    }

    @Override
    public void changeStatus(String username, Status status) {
        for(Account account : Account.getAccounts()) {
            if(account.getUsername().equals(username)) {
                account.setStatus(status);
                if(status == Status.ACTIVE) {
                    System.out.println("Kich hoat thang cong");
                }else{
                    System.out.println("ban thanh cong");
                }
            }
        }
    }
}
