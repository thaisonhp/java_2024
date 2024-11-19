import java.util.Scanner;

public class Address {
    private String commue ;
    private String street ;
    private String city ;

    public Address() {
    }

    public Address(String commue, String street, String city) {
        this.commue = commue;
        this.street = street;
        this.city = city;
    }

    public String getCommue() {
        return commue;
    }

    public void setCommue(String commue) {
        this.commue = commue;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void input() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập tên xã/phường: ");
        commue = scanner.nextLine();

        System.out.print("Nhập tên đường: ");
        street = scanner.nextLine();

        System.out.print("Nhập tên thành phố: ");
        city = scanner.nextLine();
    }

    public void output() {
        System.out.println("Địa chỉ:");
        System.out.println("Xã/Phường: " + commue);
        System.out.println("Đường: " + street);
        System.out.println("Thành phố: " + city);
    }

    @Override
    public String toString() {
        return street + "," + commue + "," + city ;
    }
}
