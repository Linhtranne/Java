package JavaPractice.entity;
import JavaPractice.util.Validator;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClassRoom {
    private static int idCounter = 1;
    private int classId;
    private String className;
    private Teacher teacher;
    private List<Student> students;

    public ClassRoom() {
        this.classId = idCounter++;
        this.students = new ArrayList<>();
    }

    public ClassRoom(String className, Teacher teacher, List<Student> students) {
        this.classId = idCounter++;
        this.className = className;
        this.teacher = teacher;
        this.students = students;
    }

    public int getClassId() {
        return classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Student> getStudents() {
        return students;
    }


    public void setStudents(List<Student> students) {
        this.students = students;
    }


    public void inputData(Scanner scanner) {
        System.out.println("Nhập thông tin lớp học:");
        while (true) {
            System.out.print("Nhập tên lớp học: ");
            String input = scanner.nextLine();
            if (Validator.validateName(input)) {
                this.className = input;
                break;
            } else {
                System.err.println("Tên lớp học không hợp lệ. Vui lòng nhập lại.");
            }
        }
        System.out.println("Nhập thông tin giảng viên:");
        Teacher teacher = new Teacher();
        teacher.inputData(scanner);
        this.teacher = teacher;

        System.out.println("Nhập danh sách sinh viên:");
        while (true) {
            System.out.print("Bạn có muốn thêm sinh viên vào lớp không? (true/false): ");
            String input = scanner.nextLine();
            if (Validator.validateBoolean(input)) {
                if (Boolean.parseBoolean(input)) {
                    Student student = new Student();
                    student.inputData(scanner);
                    this.students.add(student);
                } else {
                    break;
                }
            } else {
                System.err.println("Vui lòng nhập true hoặc false.");
            }
        }
    }

    @Override
    public String toString() {
        return "ClassRoom{" +
                "classId=" + classId +
                ", className='" + className + '\'' +
                ", teacher=" + teacher +
                ", students=" + students +
                '}';
    }
}