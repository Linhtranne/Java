package test.presentation;

import test.util.Validator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Chọn chức năng nhập:");
            System.out.println("1. Nhập vào 1 số nguyên");
            System.out.println("2. Nhập vào 1 số thực float");
            System.out.println("3. Nhập vào 1 số thực double");
            System.out.println("4. Nhập vào 1 chuỗi");
            System.out.println("5. Nhập vào true/false");
            System.out.println("6. Nhập vào 1 email");
            System.out.println("7. Nhập vào 1 số điện thoại của Việt Nam");
            System.out.println("8. Thoát");

            int choice = -1;
            while (true) {
                String choiceInput = scanner.nextLine();
                if (Validator.isInteger(choiceInput)) {
                    choice = Integer.parseInt(choiceInput);
                    break;
                } else {
                    System.out.println("Lỗi: Vui lòng nhập một số từ 1 đến 8.");
                }
            }

            try {
                switch (choice) {
                    case 1:
                        System.out.println("Nhập vào 1 số nguyên: ");
                        String intInput = scanner.nextLine();
                        if (!Validator.isInteger(intInput))
                            throw new IllegalArgumentException("Lỗi: Bạn phải nhập số nguyên!");
                        System.out.println("Số nguyên bạn vừa nhập là: " + intInput);
                        break;
                    case 2:
                        System.out.println("Nhập vào 1 số thực float: ");
                        String floatInput = scanner.nextLine();
                        if (!Validator.isFloat(floatInput))
                            throw new IllegalArgumentException("Lỗi: Bạn phải nhập số thực float!");
                        System.out.println("Số thực float bạn vừa nhập là: " + floatInput);
                        break;
                    case 3:
                        System.out.println("Nhập vào 1 số thực double: ");
                        String doubleInput = scanner.nextLine();
                        if (!Validator.isDouble(doubleInput))
                            throw new IllegalArgumentException("Lỗi: Bạn phải nhập số thực double!");
                        System.out.println("Số thực double bạn vừa nhập là: " + doubleInput);
                        break;
                    case 4:
                        System.out.println("Nhập vào min và max của chuỗi:");
                        int min = scanner.nextInt();
                        int max = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Nhập vào 1 chuỗi:");
                        String strInput = scanner.nextLine();
                        if (!Validator.isString(strInput, min, max))
                            throw new IllegalArgumentException("Lỗi: Chuỗi không hợp lệ!");
                        System.out.println("Chuỗi bạn vừa nhập là: " + strInput);
                        break;
                    case 5:
                        System.out.println("Nhập vào true/false: ");
                        String boolInput = scanner.nextLine();
                        if (!Validator.isBoolean(boolInput))
                            throw new IllegalArgumentException("Lỗi: Bạn phải nhập true/false!");
                        System.out.println("Giá trị boolean bạn vừa nhập là: " + boolInput);
                        break;
                    case 6:
                        System.out.println("Nhập vào 1 email: ");
                        String emailInput = scanner.nextLine();
                        if (!Validator.isEmail(emailInput))
                            throw new IllegalArgumentException("Lỗi: Bạn phải nhập email hợp lệ!");
                        System.out.println("Email bạn vừa nhập là: " + emailInput);
                        break;
                    case 7:
                        System.out.println("Nhập vào 1 số điện thoại của Việt Nam: ");
                        String phoneInput = scanner.nextLine();
                        if (!Validator.isPhone(phoneInput))
                            throw new IllegalArgumentException("Lỗi: Bạn phải nhập số điện thoại hợp lệ!");
                        System.out.println("Số điện thoại bạn vừa nhập là: " + phoneInput);
                        break;
                    case 8:
                        System.out.println("Thoát chương trình.");
                        return;
                    default:
                        System.out.println("Chức năng không tồn tại.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}