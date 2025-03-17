package Ex8;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập sức chứa của gara: ");
        int capacity = sc.nextInt();
        Garage garage = new Garage(capacity);

        while (true) {
            System.out.println("\n1. Thêm xe vào gara");
            System.out.println("2. Khởi động tất cả xe");
            System.out.println("3. Dừng tất cả xe");
            System.out.println("4. Nạp nhiên liệu cho tất cả xe");
            System.out.println("5. Thoát");
            System.out.print("Chọn chức năng: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    if (garage.count < capacity) {
                        System.out.print("Nhập loại xe (1: Xe điện, 2: Xe xăng): ");
                        int type = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Nhập tên xe: ");
                        String name = sc.nextLine();
                        System.out.print("Nhập năm sản xuất: ");
                        int year = sc.nextInt();
                        System.out.print("Nhập giá: ");
                        double price = sc.nextDouble();

                        Car car;
                        if (type == 1) {
                            car = new ElectricCar(name, year, price);
                        } else {
                            car = new GasCar(name, year, price);
                        }
                        garage.addCar(car);
                    } else {
                        System.out.println("Gara đã đầy!");
                    }
                    break;

                case 2:
                    garage.startAll();
                    break;

                case 3:
                    garage.stopAll();
                    break;

                case 4:
                    garage.refuelAll();
                    break;

                case 5:
                    System.out.println("Thoát chương trình.");
                    sc.close();
                    return;

                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }
}
