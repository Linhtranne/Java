package JavaPractice.business;

import JavaPractice.entity.Course;
import JavaPractice.entity.Student;
import JavaPractice.entity.Teacher;
import JavaPractice.entity.CourseRegistration;
import java.util.*;
import java.util.stream.Collectors;

public class DashboardManagement {
    private List<Student> students;
    private List<Teacher> teachers;
    private List<Course> courses;
    private List<CourseRegistration> registrations;

    public DashboardManagement(List<Student> students, List<Teacher> teachers, List<Course> courses, List<CourseRegistration> registrations) {
        this.students = students;
        this.teachers = teachers;
        this.courses = courses;
        this.registrations = registrations;
    }

    public void displayStatistics() {
        System.out.println("Thống kê:");
        System.out.println("Số sinh viên: " + students.size());
        System.out.println("Số giảng viên: " + teachers.size());
        System.out.println("Số khóa học: " + courses.size());
        System.out.println("Số lớp học: " + registrations.stream().map(CourseRegistration::getCourseId).distinct().count());
    }

    public void displayTopCourses() {
        System.out.println("Top 3 khóa học có nhiều sinh viên nhất:");
        registrations.stream()
                .collect(Collectors.groupingBy(CourseRegistration::getCourseId, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(3)
                .forEach(entry -> {
                    Course course = findCourseById(entry.getKey());
                    if (course != null) {
                        System.out.println(course.getCourseName() + " - " + entry.getValue() + " sinh viên");
                    }
                });
    }

    public void displayTopClasses() {
        System.out.println("Top 3 lớp học có nhiều sinh viên nhất:");
        registrations.stream()
                .collect(Collectors.groupingBy(CourseRegistration::getCourseId, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(3)
                .forEach(entry -> System.out.println("Mã lớp: " + entry.getKey() + " - " + entry.getValue() + " sinh viên"));
    }

    public void displayTopTeachers() {
        System.out.println("Top 3 giảng viên dạy nhiều sinh viên nhất:");
        registrations.stream()
                .collect(Collectors.groupingBy(reg -> findTeacherByCourseId(reg.getCourseId()), Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getKey() != null)
                .sorted(Map.Entry.<Teacher, Long>comparingByValue().reversed())
                .limit(3)
                .forEach(entry -> System.out.println(entry.getKey().getName() + " - " + entry.getValue() + " sinh viên"));
    }

    public void displayTopStudents() {
        System.out.println("Top 3 sinh viên đăng ký học nhiều nhất:");
        registrations.stream()
                .collect(Collectors.groupingBy(CourseRegistration::getStudent, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<Student, Long>comparingByValue().reversed())
                .limit(3)
                .forEach(entry -> System.out.println(entry.getKey().getName() + " - " + entry.getValue() + " khóa học"));
    }

    private Course findCourseById(String courseId) {
        return courses.stream().filter(c -> c.getCourseId().equals(courseId)).findFirst().orElse(null);
    }

    private Teacher findTeacherByCourseId(String courseId) {
        return teachers.stream().filter(t -> t.getCourses().contains(courseId)).findFirst().orElse(null);
    }
}