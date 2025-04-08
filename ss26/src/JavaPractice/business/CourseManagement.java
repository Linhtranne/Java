package JavaPractice.business;

import JavaPractice.entity.Course;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class CourseManagement {
    private List<Course> courses;

    public CourseManagement(List<Course> courses) {
        this.courses = courses;
    }

    public void listCourses() {
        courses.sort(Comparator.comparing(Course::getCourseName));
        courses.forEach(System.out::println);
    }

    public void addCourse(Scanner scanner) {
        Course course = new Course();
        course.inputData(scanner);
        courses.add(course);
        System.out.println("Khóa học đã được thêm thành công.");
    }

    // 3. Update course information
    public void updateCourse(Scanner scanner) {
        System.out.print("Nhập mã khóa học cần cập nh���t: ");
        String courseId = scanner.nextLine();
        Course course = findCourseById(courseId);
        if (course != null) {
            course.inputData(scanner);
            System.out.println("Thông tin khóa học đã được cập nhật.");
        } else {
            System.out.println("Không tìm thấy khóa học với mã đã nhập.");
        }
    }

    public void deleteCourse(Scanner scanner) {
        System.out.print("Nhập mã khóa học cần xóa: ");
        String courseId = scanner.nextLine();
        Course course = findCourseById(courseId);
        if (course != null) {
            courses.remove(course);
            System.out.println("Khóa học đã được xóa thành công.");
        } else {
            System.out.println("Không tìm thấy khóa học với mã đã nhập.");
        }
    }

    private Course findCourseById(String id) {
        return courses.stream()
                .filter(c -> c.getCourseId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
