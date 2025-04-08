package JavaPractice.entity;

import JavaPractice.util.Validator;
import java.util.Scanner;

public class Teacher extends Person {
    private static int idCounter = 1;
    private int teacherId;
    private String subject;

    public Teacher() {
        this.teacherId = idCounter++;
    }

    public Teacher(String name, int age, String address, String phone, String email, Sex sex, String subject) {
        super(name, age, address, phone, email, sex);
        this.teacherId = idCounter++;
        this.subject = subject;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public void inputData(Scanner scanner) {
        super.inputData(scanner);

        while (true) {
            System.out.print("Nhập chuyên môn giảng viên: ");
            String input = scanner.nextLine();
            if (Validator.validateSubject(input)) {
                this.subject = input;
                break;
            } else {
                System.err.println("Chuyên môn không hợp lệ. Vui lòng nhập lại.");
            }
        }
    }

    @Override
    public String toString() {
        return "Giáo viên{" +
                "Mã giáo viên" + teacherId +
                ", Môn học'" + subject + '\'' +
                ", " + super.toString() +
                '}';
    }
}