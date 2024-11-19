import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class ClassRoom {
    private static ArrayList<Student> listStudent = new ArrayList<>();

    public void sortByGpa(){
        Collections.sort(listStudent, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1.getGpa() > o2.getGpa()) {
                    return 1;
                }else if (o1.getGpa() < o2.getGpa()) {
                    return -1;
                }else {
                    return 0;
                }
            }
        });
    }
    public void inputList() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Nhập thông tin sinh viên: ");
            Student newStudnet = new Student();
            newStudnet.input();
            if (newStudnet.getId() == 555) {
                listStudent.add(newStudnet);
                break;
            }
            listStudent.add(newStudnet);
        }
    }
    public void outputList(){
        System.out.println("Thông tin danh sách sinh viên trong lớp học là");
        System.out.printf("%-15s %-5s %-40s %-10s %-10s %-5s\n",
                "Tên", "Tuổi", "Địa chỉ", "Mã SV", "Lớp", "GPA");
        System.out.println("---------------------------------------------------------------------------------------------------");
        for (Student student : listStudent) {
            System.out.printf("%-15s %-5d %-40s %-10s %-10s %-5.2f\n",
                    student.getName(),
                    student.getAge(),
                    student.getAddress().toString(),
                    student.getId(),
                    student.getNameClass(),
                    student.getGpa());
        }
        System.out.println("Đã sắp xếp xong") ;
    }

    public boolean removeById(int id){
        for(Student student : listStudent){
            if(student.getId() == id){
                listStudent.remove(student);
                System.out.println("Xoá thành công");
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ClassRoom classRoom = new ClassRoom();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("====== MENU ======");
            System.out.println("1. Nhập thông tin sinh viên");
            System.out.println("2. In thông tin sinh viên dạng bảng");
            System.out.println("3. Sắp xếp danh sách sinh viên theo điểm gpa:");
            System.out.println("4. Xóa sinh viên theo id(nhập id từ bàn phím)");
            System.out.println("5. Thoát chương trình");
            System.out.print("Lựa chọn: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    classRoom.inputList();
                    break;
                case 2:
                    classRoom.outputList();
                    break;
                case 3:
                    classRoom.sortByGpa();
                    break ;
                case 4:
                    System.out.println("Nhập ID của sinh viên muốn xoá:");
                    int id = scanner.nextInt();
                    classRoom.removeById(id);
                    break;
                case 5:
                    System.out.println("Dừng chương trình!");
                    break ;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
            }
        } while (choice != 5);

    }


}
