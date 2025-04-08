package JavaPractice.entity;

import JavaPractice.util.Validator;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class CourseRegistration {
    private static int idCounter = 1;
    private int registrationId;
    private Student student;
    private String courseId;
    private LocalDate registrationDate;

    public CourseRegistration() {
        this.registrationId = idCounter++;
    }

    public CourseRegistration(Student student, String courseId, LocalDate registrationDate) {
        this.registrationId = idCounter++;
        this.student = student;
        this.courseId = courseId;
        this.registrationDate = registrationDate;
    }

    public int getRegistrationId() {
        return registrationId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public void inputData(Scanner scanner) {
        System.out.println("Nhập thông tin đăng ký khóa học:");
        System.out.println("Nhập thông tin sinh viên:");
        Student student = new Student();
        student.inputData(scanner);
        this.student = student;
        while (true) {
            System.out.print("Nhập mã khóa học (bắt đầu bằng C, 5 ký tự): ");
            String input = scanner.nextLine();
            if (Validator.validateCourseId(input)) {
                this.courseId = input;
                break;
            } else {
                System.err.println("Mã khóa học không hợp lệ. Vui lòng nhập lại.");
            }
        }
        while (true) {
            System.out.print("Nhập ngày đăng ký (định dạng yyyy-MM-dd): ");
            String input = scanner.nextLine();
            try {
                LocalDate date = LocalDate.parse(input, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                this.registrationDate = date;
                break;
            } catch (DateTimeParseException e) {
                System.err.println("Ngày không hợp lệ. Vui lòng nhập lại.");
            }
        }
    }

    @Override
    public String toString() {
        return "CourseRegistration{" +
                "registrationId=" + registrationId +
                ", student=" + student +
                ", courseId='" + courseId + '\'' +
                ", registrationDate=" + registrationDate +
                '}';
    }
}