package views;

import controller.Impl.AccountServiceImpl;
import controller.Impl.AuthServiceImpl;
import model.Account;
import model.Address;
import model.Role;
import model.Status;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Views {
    public void viewForAdmin(Account admin , AuthServiceImpl authService) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("==== Hệ thống quản lý tài khoản ====");
            System.out.println("Xin chào Admin"+ admin.getUsername());
            System.out.println("Chọn một trong các chức năng sau :");
            System.out.println("1. Xem danh sách tài khoản ");
            System.out.println("2. Tạo tài khoản mới ");
            System.out.println("3. Tìm kiếm tài khoản theo username");
            System.out.println("4. Xoá tài khoản ");
            System.out.println("5. Thay đổi trạng thái của tài khoản (ACTIVE / BAN )");
            System.out.println("6. Xem thông tin cá nhân ");
            System.out.println("0. Đăng xuất");
            System.out.println("-------------------------");
            System.out.print("Nhập lựa chọnc của bạn: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            AccountServiceImpl accountManager = new AccountServiceImpl();
            switch (choice) {
                case 1:
                    List<Account> accounts = accountManager.getAllAccount();
                    System.out.println("Dưới đây là danh sách account:");
                    for (Account account : accounts) {
                        System.out.println(account);
                    }
                    break;
                case 2:
                    System.out.println("Nhập thông tin để tạo tài khoản:");
                    System.out.print("Nhập thông fullName:");
                    String fullName = scanner.nextLine();
                    System.out.print("Nhap tuoi");
                    int age = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Nhap thong tin dia chi:");
                    System.out.print("Nhap duong:");
                    String street = scanner.nextLine();
                    System.out.print("Nhap thanh pho");
                    String city = scanner.nextLine();
                    Address address = new Address(street,city) ;
                    System.out.println("Nhap ngay sinh (dd/mm/yyyy)):");
                    String birthday = scanner.nextLine();
                    System.out.println("Nhap userName:");
                    String userName = scanner.nextLine();
                    System.out.println("Nhap userPassword:");
                    String passWord = scanner.nextLine();
                    Role role = Role.USER ;
                    Status status = Status.ACTIVE ;
                    Account account = new Account(Integer.toString(Account.getCount() + 1),fullName,age,address,birthday,userName,passWord,role,status);
                    accountManager.createNewAccount(account);
                    break;
                case 3:
                    System.out.print("Nhập userName cần tìm kiếm: ");
                    String username = scanner.nextLine();
                    accountManager.getAccountByUsername(username);
                    break;
                case 4:
                    System.out.print("Nhập username của tài khoản muốn xoá :");
                    String userNameToDelete = scanner.nextLine();
                    accountManager.deleteAccount(userNameToDelete);
                    break;
                case 5:
                    System.out.println("Nhập username mà bạn muốn thay đổi:");
                    String userNameToChange = scanner.nextLine();
                    System.out.println("Nhập trạng thái :");
                    String statusString = scanner.nextLine();
                    Status statusToChange = null;
                    if (statusString.equals("ACTIVE")) {
                        statusToChange = Status.ACTIVE;
                    }else if (statusString.equals("BANNED")) {
                        statusToChange = Status.BAN;
                    }
                    accountManager.changeStatus(userNameToChange,statusToChange);
                    break;
                case 6 :
                    System.out.println("Danh sách cá nhân chi tiết là :");
                    for (Account account1 : accountManager.getAllAccount()) {
                        System.out.println("Name" + account1.getUsername());
                        System.out.println("Age" + account1.getAge());
                        System.out.println("Address" + account1.getAddress());
                        System.out.println("birthday" + account1.getBirthday());
                    }
                    break;
                case 0:
                    authService.logout() ;
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }
    public void viewForUser(Account user ,AuthServiceImpl authService ) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("==== Hệ thống người dùng ====");
            System.out.println("Xin chào User :" + user.getUsername());
            System.out.println("Chọn một trong các chức năng sau :");
            System.out.println("1. Đổi mật khẩu ");
            System.out.println("2. Xem thông tin cá nhân ");
            System.out.println("0. Đăng xuất");
            System.out.println("------------------------");
            System.out.print("Mời nhập lựa chọn của bạn: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            AccountServiceImpl accountManager = new AccountServiceImpl();
            switch (choice) {
                case 1:
                    System.out.print("Nhập username cần đổi :");
                    String username = scanner.nextLine();
                    System.out.print("Nhập password cũ:");
                    String password = scanner.nextLine();
                    System.out.print("Nhập password mới:");
                    String newpassword = scanner.nextLine();
                    authService.changePassword(username,password,newpassword);
                    break;
                case 2:
                    System.out.println("Thông tin cá nhân là :");
                    System.out.println("Name" + user.getUsername());
                    System.out.println("Age" + user.getAge());
                    System.out.println("Address" + user.getAddress());
                    System.out.println("birthday" + user.getBirthday());
                    break;
                case 0:
                    authService.logout();
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }
}
