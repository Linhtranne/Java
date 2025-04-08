package JavaPractice.entity;
import JavaPractice.util.Validator;

import java.util.List;
import java.util.Scanner;

public class Student extends Person {
    private String studentId;
    private double gpa;
    private List<String> registeredCourses;
    public Student() {
    }

    public Student(String name, int age, String address, String phone, String email, Sex sex, String studentId, double gpa) {
        super(name, age, address, phone, email, sex);
        this.studentId = studentId;
        this.gpa = gpa;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
    public void setRegisteredCourses(List<String> registeredCourses) {
        this.registeredCourses = registeredCourses;
    }

    @Override
    public void inputData(Scanner scanner) {
        super.inputData(scanner);

        while (true) {
            System.out.print("Nhập mã sinh viên (bắt đầu bằng SV, 5 ký tự): ");
            String input = scanner.nextLine();
            if (Validator.validateStudentId(input)) {
                this.studentId = input;
                break;
            } else {
                System.err.println("Mã sinh viên không hợp lệ. Vui lòng nhập lại.");
            }
        }

        while (true) {
            System.out.print("Nhập điểm trung bình (0.0 - 4.0): ");
            try {
                double input = Double.parseDouble(scanner.nextLine());
                if (Validator.validateGpa(input)) {
                    this.gpa = input;
                    break;
                } else {
                    System.err.println("Điểm trung bình không hợp lệ. Vui lòng nhập lại.");
                }
            } catch (NumberFormatException e) {
                System.err.println("Vui lòng nhập một số hợp lệ.");
            }
        }
    }

    @Override
    public String toString() {
        return "Sinh viên{" +
                "Mã sinh viên'" + studentId + '\'' +
                ", GPA=" + gpa +
                ", " + super.toString() +
                '}';
    }
}