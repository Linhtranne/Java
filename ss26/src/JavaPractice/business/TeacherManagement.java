package JavaPractice.business;

import JavaPractice.entity.Teacher;
import JavaPractice.util.Validator;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class TeacherManagement {
    private List<Teacher> teachers;

    public TeacherManagement(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public void listTeachers() {
        teachers.sort(Comparator.comparing(Teacher::getName));
        teachers.forEach(System.out::println);
    }

    public void addTeacher(Scanner scanner) {
        Teacher teacher = new Teacher();
        teacher.inputData(scanner);
        teachers.add(teacher);
        System.out.println("Giáo viên đã được thêm thành công.");
    }

    public void updateTeacher(Scanner scanner) {
        System.out.print("Nhập ID giáo viên cần cập nhật: ");
        int id = Integer.parseInt(scanner.nextLine());
        Teacher teacher = findTeacherById(id);
        if (teacher != null) {
            teacher.inputData(scanner);
            System.out.println("Thông tin giáo viên đã được cập nhật.");
        } else {
            System.out.println("Không tìm thấy giáo viên với ID đã nhập.");
        }
    }

    public void deleteTeacher(Scanner scanner) {
        System.out.print("Nhập ID giáo viên cần xóa: ");
        int id = Integer.parseInt(scanner.nextLine());
        Teacher teacher = findTeacherById(id);
        if (teacher != null) {
            teachers.remove(teacher);
            System.out.println("Giáo viên đã được xóa thành công.");
        } else {
            System.out.println("Không tìm thấy giáo viên với ID đã nhập.");
        }
    }
    private Teacher findTeacherById(int id) {
        return teachers.stream()
                .filter(t -> t.getTeacherId() == id)
                .findFirst()
                .orElse(null);
    }
}