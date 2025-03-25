package Ex11.presentation;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

import Ex11.entity.Student;
public class StudentManagement {
    private static Map<String, Student> student= new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("1. Danh sách sinh viên");
            System.out.println("2. Thêm mới các sinh sinh viên");
            System.out.println("3. Xóa sinh viên theo mã sinh viên");
            System.out.println("4. Tính điểm trung bình của tất cả sinh viên");
            System.out.println("5. In sinh viên có số điểm trung bình lớn nhất");
            System.out.println("6. In sinh viên có tuổi nhỏ nhất");
            System.out.println("Chọn chức năng: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    showStudent();
                    break;
                case 2:
                    addStudent();
                    break;
                case 3:
                    deleteStudentById();
                    break;
                case 4:
                    calculateAVGMark();
                    break;
                case 5:
                    showStudentHasMaxMark();
                    break;
                case 6:
                    showStudentHasMinAge();
                    break;
                case 7:
                    System.exit(0);

            }
        }while (choice != 7);
    }
    public static void showStudent() {
        if (student.isEmpty()) {
            System.out.println("Không có sinh viên nào.");
        } else {
            for (Student Student : student.values()) {
                System.out.println(Student);
            }
        }
    }
    public static void addStudent() {
        System.out.print("Nhập mã sinh viên: ");
        String id = scanner.nextLine();
        System.out.print("Nhập tên sinh viên: ");
        String name = scanner.nextLine();
        System.out.print("Nhập tuổi sinh viên: ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập điểm trung bình: ");
        double mark = Double.parseDouble(scanner.nextLine());
        Student Student = new Student(id, name, age, (float) mark);
        student.put(Student.getId(), Student);
    }
    public static void deleteStudentById(){
        System.out.print("Nhập mã sinh viên cần xóa: ");
        String id = scanner.nextLine();
        student.remove(id);
    }
    public static void calculateAVGMark(){
        double totalMark = 0;
        for (Student value : student.values()) {
            totalMark += value.getMark();
        }
        double avgMark = totalMark / student.size();
        System.out.println("Điểm trung bình của tất cả sinh viên: " + avgMark);
    }
    public static void showStudentHasMaxMark(){
        List<Student> studentList = new ArrayList<>(student.values());
        studentList.sort(Student::Comparator);
        System.out.println("Sinh viên có số điểm trung bình lớn nhất: ");
        System.out.println(studentList.get(0));

    }
    public static void showStudentHasMinAge(){
        List<Student> studentList = new ArrayList<>(student.values());
        studentList.sort((s1, s2) -> s1.getAge() - s2.getAge());
        System.out.println("Sinh viên có tuổi nhỏ nhất: ");
        System.out.println(studentList.get(0));
    }
}
