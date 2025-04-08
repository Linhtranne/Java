package JavaPractice.entity;

import JavaPractice.util.Validator;
import java.util.Scanner;

public class Person implements IApp {
    private String name;
    private int age;
    private String address;
    private String phone;
    private String email;
    private Sex sex;

    public enum Sex {
        MALE, FEMALE, OTHER
    }

    public Person() {
    }

    public Person(String name, int age, String address, String phone, String email, Sex sex) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    @Override
    public void inputData(Scanner scanner) {
        while (true) {
            System.out.print("Nhập tên (tối đa 150 ký tự): ");
            String input = scanner.nextLine();
            if (Validator.validateName(input)) {
                this.name = input;
                break;
            } else {
                System.err.println("Tên không hợp lệ. Vui lòng nhập lại.");
            }
        }

        while (true) {
            System.out.print("Nhập tuổi (tối thiểu 18): ");
            int input = Integer.parseInt(scanner.nextLine());
            if (Validator.validateAge(input)) {
                this.age = input;
                break;
            } else {
                System.err.println("Tuổi không hợp lệ. Vui lòng nhập lại.");
            }
        }

        while (true) {
            System.out.print("Nhập địa chỉ: ");
            String input = scanner.nextLine();
            if (Validator.validateAddress(input)) {
                this.address = input;
                break;
            } else {
                System.err.println("Địa chỉ không hợp lệ. Vui lòng nhập lại.");
            }
        }

        while (true) {
            System.out.print("Nhập số điện thoại (định dạng số điện thoại di động Việt Nam): ");
            String input = scanner.nextLine();
            if (Validator.validatePhone(input)) {
                this.phone = input;
                break;
            } else {
                System.err.println("Số điện thoại không hợp lệ. Vui lòng nhập lại.");
            }
        }

        while (true) {
            System.out.print("Nhập email: ");
            String input = scanner.nextLine();
            if (Validator.validateEmail(input)) {
                this.email = input;
                break;
            } else {
                System.err.println("Email không hợp lệ. Vui lòng nhập lại.");
            }
        }

        while (true) {
            System.out.print("Nhập giới tính");
            String input = scanner.nextLine().toUpperCase();
            try {
                this.sex = Sex.valueOf(input);
                break;
            } catch (IllegalArgumentException e) {
                System.err.println("Giới tính không hợp lệ. Vui lòng nhập lại.");
            }
        }
    }

    @Override
    public String toString() {
        return "Người" +
                "Tên'" + name + '\'' +
                "Tuổi" + age +
                "Địa chỉ'" + address + '\'' +
                "Số điện thoại'" + phone + '\'' +
                "Email'" + email + '\'' +
                "Giới tính" + sex +
                '}';
    }
}