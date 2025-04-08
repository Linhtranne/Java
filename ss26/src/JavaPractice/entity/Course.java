package JavaPractice.entity;

import java.util.Scanner;
import JavaPractice.util.Validator;
public class Course implements IApp {
    private String courseId;
    private String courseName;
    private boolean status;

    public Course() {
    }

    public Course(String courseId, String courseName, boolean status) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.status = status;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

@Override
public void inputData(Scanner scanner) {
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
        System.out.print("Nhập tên khóa học (20-100 ký tự): ");
        String input = scanner.nextLine();
        if (Validator.validateCourseName(input)) {
            this.courseName = input;
            break;
        } else {
            System.err.println("Tên khóa học không hợp lệ. Vui lòng nhập lại.");
        }
    }

    while (true) {
        System.out.print("Nhập trạng thái khóa học (true/false): ");
        String input = scanner.nextLine();
        if (Validator.validateBoolean(input)) {
            this.status = Boolean.parseBoolean(input);
            break;
        } else {
            System.err.println("Trạng thái không hợp lệ. Vui lòng nhập lại.");
        }
    }
}

    @Override
    public String toString() {
        return "Course{" +
                "courseId='" + courseId + '\'' +
                ", courseName='" + courseName + '\'' +
                ", status=" + status +
                '}';
    }
}