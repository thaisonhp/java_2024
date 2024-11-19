import java.util.Scanner;

public class Person {
    protected String name;
    protected int age;
    protected Address address = new Address();

    public Person() {
    }

    public Person(String name, int age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address=" + address +
                '}';
    }

    public void input() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập tên : ");
        name = scanner.nextLine();

        System.out.print("Nhập tuổi: ");
        age = scanner.nextInt();

        System.out.println("Nhập thông tin địa chỉ : ");
        address.input();
    }

    public void output() {
        System.out.println("Thông tin người :");
        System.out.println("Tên: " + name);
        System.out.println("Tuổi: " + age);
        address.output();
    }
}
