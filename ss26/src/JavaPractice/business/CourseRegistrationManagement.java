package JavaPractice.business;

import JavaPractice.entity.Course;
import JavaPractice.entity.Student;
import JavaPractice.entity.CourseRegistration;
import JavaPractice.util.Validator;

import java.util.List;
import java.util.Scanner;

public class CourseRegistrationManagement {
    private List<CourseRegistration> registrations;
    private List<Course> courses;
    private List<Student> students;

    public CourseRegistrationManagement(List<CourseRegistration> registrations, List<Course> courses, List<Student> students) {
        this.registrations = registrations;
        this.courses = courses;
        this.students = students;
    }

    public void registerCourse(Scanner scanner) {
        System.out.print("Nhập ID sinh viên: ");
        int studentId = Integer.parseInt(scanner.nextLine());
        Student student = findStudentById(studentId);
        if (student != null) {
            System.out.print("Nhập mã khóa học: ");
            String courseId = scanner.nextLine();
            Course course = findCourseById(courseId);
            if (course != null) {
                CourseRegistration registration = new CourseRegistration(student, courseId, java.time.LocalDate.now());
                registrations.add(registration);
                System.out.println("Đăng ký khóa học thành công.");
            } else {
                System.out.println("Không tìm thấy khóa học với mã đã nhập.");
            }
        } else {
            System.out.println("Không tìm thấy sinh viên với ID đã nhập.");
        }
    }

    public void cancelRegistration(Scanner scanner) {
        System.out.print("Nhập ID sinh viên: ");
        int studentId = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập mã khóa học: ");
        String courseId = scanner.nextLine();
        CourseRegistration registration = findRegistration(studentId, courseId);
        if (registration != null) {
            registrations.remove(registration);
            System.out.println("Hủy đăng ký khóa học thành công.");
        } else {
            System.out.println("Không tìm thấy đăng ký với thông tin đã nhập.");
        }
    }

    public void viewRegistrationsByCourse(Scanner scanner) {
        System.out.print("Nhập mã khóa học: ");
        String courseId = scanner.nextLine();
        Course course = findCourseById(courseId);
        if (course != null) {
            System.out.println("Danh sách sinh viên đăng ký khóa học " + course.getCourseName() + ":");
            registrations.stream()
                    .filter(r -> r.getCourseId().equals(courseId))
                    .forEach(r -> System.out.println(r.getStudent()));
        } else {
            System.out.println("Không tìm thấy khóa học với mã đã nhập.");
        }
    }

    private Student findStudentById(int id) {
        return students.stream()
                .filter(s -> s.getStudentId().equals(String.valueOf(id)))
                .findFirst()
                .orElse(null);
    }

    private Course findCourseById(String id) {
        return courses.stream().filter(c -> c.getCourseId().equals(id)).findFirst().orElse(null);
    }

    private CourseRegistration findRegistration(int studentId, String courseId) {
        return registrations.stream()
                .filter(r -> r.getStudent().getStudentId().equals(String.valueOf(studentId)) && r.getCourseId().equals(courseId))
                .findFirst()
                .orElse(null);
    }
}