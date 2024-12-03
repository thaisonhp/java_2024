package model;

import java.util.ArrayList;

public class Account extends Person{
    private String username;
    private String password;
    private Role role;
    private Status status;
    private static ArrayList<Account> accounts = new ArrayList<>();
    private static int count = 0;

    public Account() {
    }

    public Account(String username, String password, Role role, Status status) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.status = status;
    }

    public Account(String id, String fullName, int age, Address address, String birthday, String username, String password, Role role, Status status) {
        super(id, fullName, age, address, birthday);
        this.username = username;
        this.password = password;
        this.role = role;
        this.status = status;
        count++ ;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public static ArrayList<Account> getAccounts() {
        return accounts;
    }

    public static void setAccounts(ArrayList<Account> accounts) {
        Account.accounts = accounts;
    }

    public static int getCount() {
        return count;
    }



    @Override
    public String toString() {
        return "Account{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", status=" + status +
                '}';
    }
}
