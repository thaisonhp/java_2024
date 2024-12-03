package controller;
import  java.util.*;
public interface AuthService {
    public boolean login(Scanner scanner) ;
    public boolean logout() ;
    public void changePassword(String username, String oldPassword, String newPassword);
    public boolean checkAdmin();
}
