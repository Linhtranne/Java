package JavaPractice.business;

import JavaPractice.entity.Student;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class StudentManagement {
    private List<Student> students;

    public StudentManagement(List<Student> students) {
        this.students = students;
    }

    public void listStudents() {
        students.sort(Comparator.comparing(Student::getName));
        students.forEach(System.out::println);
    }
    public void addStudent(Scanner scanner) {
        Student student = new Student();
        student.inputData(scanner);
        students.add(student);
        System.out.println("Sinh viên đã được thêm thành công.");
    }
    public void updateStudent(Scanner scanner) {
        System.out.print("Nhập ID sinh viên cần cập nhật: ");
        int id = Integer.parseInt(scanner.nextLine());
        Student student = findStudentById(id);
        if (student != null) {
            student.inputData(scanner);
            System.out.println("Thông tin sinh viên đã được cập nhật.");
        } else {
            System.out.println("Không tìm thấy sinh viên với ID đã nhập.");
        }
    }

    public void deleteStudent(Scanner scanner) {
        System.out.print("Nhập ID sinh viên cần xóa: ");
        int id = Integer.parseInt(scanner.nextLine());
        Student student = findStudentById(id);
        if (student != null) {
            if (student.getRegisteredCourses().isEmpty()) {
                students.remove(student);
                System.out.println("Sinh viên đã được xóa thành công.");
            } else {
                System.out.println("Không thể xóa sinh viên đã đăng ký khóa học.");
            }
        } else {
            System.out.println("Không tìm thấy sinh viên với ID đã nhập.");
        }
    }

    // Helper method to find a student by ID
    private Student findStudentById(int id) {
        return students.stream()
                .filter(s -> s.getStudentId().equals(String.valueOf(id)))
                .findFirst()
                .orElse(null);
    }
}