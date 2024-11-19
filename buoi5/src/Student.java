import java.util.Scanner;

public class Student extends Person {
    private int id ;
    private String nameClass ;
    private float gpa ;
    private final float criteria = 2 ;

    public Student() {
    }

    public Student(String name, int age, Address address, int id, String nameClass, float gpa) {
        super(name, age, address);
        this.id = id;
        this.nameClass = nameClass;
        this.gpa = gpa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameClass() {
        return nameClass;
    }

    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    public float getCriteria() {
        return criteria;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", nameClass='" + nameClass + '\'' +
                ", gpa=" + gpa +
                ", criteria=" + criteria +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address=" + address +
                '}';
    }

    @Override
    public void input() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập mã sinh viên:");
        id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nhập tên : ");
        name = scanner.nextLine();

        System.out.print("Nhập tuổi: ");
        age = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Nhập thông tin địa chỉ : ");
        address.input();

        System.out.print("Nhập tên lớp học :");
        nameClass = scanner.nextLine();

        System.out.print("Nhập điểm Gpa :");
        gpa = scanner.nextFloat();
        scanner.nextLine();
    }
    @Override
    public void output() {
        System.out.println("Thông tin sinh viên :");
        System.out.println("Tên: " + name);
        System.out.println("Tuổi: " + age);
        address.output();
        System.out.println("Mã sinh viên:" + id) ;
        System.out.println("Lớp:" + nameClass);
        System.out.println("Gpa:" + gpa);
    }

    public boolean checkFall(){
        if(gpa < criteria){
            return true;
        }else return false;
    }

}
