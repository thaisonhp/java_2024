import controller.Impl.AuthServiceImpl;
import model.Account;
import views.Views;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AuthServiceImpl authentic = new AuthServiceImpl();
        Scanner scanner = new Scanner(System.in);
        if (authentic.login(scanner)){
            Views view = new Views();
            Account now = authentic.getCurrentAccount();
            if(authentic.checkAdmin()){
                view.viewForAdmin(now,authentic);
            }else {
                view.viewForUser(now,authentic);
            }
        }
    }
}