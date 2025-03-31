package Ex8;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> validPhoneNumbers = new ArrayList<>();
        List<String> invalidPhoneNumbers = new ArrayList<>();

        System.out.println("Nhập số điện thoại:");
        String input = scanner.nextLine();
        String[] phoneNumbers = input.split(",");

        for (String phone : phoneNumbers) {
            phone = phone.trim();
            try {
                InvalidPhoneNumberLengthException.validatePhoneNumber(phone);
                validPhoneNumbers.add(phone);
            } catch (InvalidPhoneNumberLengthException e) {
                invalidPhoneNumbers.add(e.getMessage());
            }
        }

        System.out.println("Số điện thoại hợp lệ: " + validPhoneNumbers);
        System.out.println("Số điện thoại không hợp lệ: " + invalidPhoneNumbers);
    }
}