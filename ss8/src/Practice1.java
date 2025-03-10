import java.util.Scanner;

public class Practice1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 0;
        int[] arr = new int[1000];
        int choice;

        do {
            System.out.println("***********************MENU**************************");
            System.out.println("1. Nhập giá trị n phần tử của mảng");
            System.out.println("2. In giá trị các phần tử trong mảng");
            System.out.println("3. Tính trung bình các phần tử dương (>0) trong mảng");
            System.out.println("4. In ra vị trí các phần tử có giá trị bằng k");
            System.out.println("5. Sắp xếp mảng giảm dần (Bubble Sort)");
            System.out.println("6. Đếm số lượng phần tử là số nguyên tố trong mảng");
            System.out.println("7. Sắp xếp theo yêu cầu đặc biệt");
            System.out.println("8. Chèn giá trị m vào mảng (đã sắp xếp giảm dần)");
            System.out.println("9. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Vui lòng nhập số phần tử trong mảng: ");
                    n = sc.nextInt();
                    for (int i = 0; i < n; i++) {
                        System.out.printf("arr[%d] = ", i);
                        arr[i] = sc.nextInt();
                    }
                    break;
                case 2:
                    System.out.print("Các phần tử trong mảng là: ");
                    for (int i = 0; i < n; i++) {
                        System.out.print(arr[i] + " ");
                    }
                    System.out.println();
                    break;
                case 3:
                    int sum = 0, count = 0;
                    for (int i = 0; i < n; i++) {
                        if (arr[i] > 0) {
                            sum += arr[i];
                            count++;
                        }
                    }
                    if (count > 0) {
                        System.out.printf("Trung bình của các số dương trong mảng là: %.2f\n", (double) sum / count);
                    } else {
                        System.out.println("Không có số dương trong mảng để tính trung bình.");
                    }
                    break;
                case 4:
                    System.out.print("Nhập giá trị k: ");
                    int k = sc.nextInt();
                    boolean found = false;
                    System.out.println("Chỉ số của các phần tử có giá trị bằng k là:");
                    for (int i = 0; i < n; i++) {
                        if (arr[i] == k) {
                            System.out.println(i);
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("Không có phần tử nào có giá trị bằng k.");
                    }
                    break;
                case 5:
                    for (int i = 0; i < n - 1; i++) {
                        for (int j = 0; j < n - i - 1; j++) {
                            if (arr[j] < arr[j + 1]) {
                                int temp = arr[j];
                                arr[j] = arr[j + 1];
                                arr[j + 1] = temp;
                            }
                        }
                    }
                    System.out.print("Mảng sau khi sắp xếp giảm dần: ");
                    for (int i = 0; i < n; i++) {
                        System.out.print(arr[i] + " ");
                    }
                    System.out.println();
                    break;
                case 6:
                    count = 0;
                    for (int i = 0; i < n; i++) {
                        if (arr[i] > 1) {
                            boolean isPrime = true;
                            for (int j = 2; j <= Math.sqrt(arr[i]); j++) {
                                if (arr[i] % j == 0) {
                                    isPrime = false;
                                    break;
                                }
                            }
                            if (isPrime) {
                                count++;
                            }
                        }
                    }
                    System.out.println("Số lượng các số nguyên tố trong mảng là: " + count);
                    break;
                case 7:
                    for (int i = 0; i < n - 1; i++) {
                        for (int j = i + 1; j < n; j++) {
                            if ((arr[i] % 3 != 0 && arr[j] % 3 == 0) || (arr[i] % 2 != 0 && arr[j] % 2 == 0 && arr[j] % 3 == 0)) {
                                int temp = arr[i];
                                arr[i] = arr[j];
                                arr[j] = temp;
                            }
                        }
                    }
                    System.out.print("Mảng sau khi sắp xếp theo yêu cầu: ");
                    for (int i = 0; i < n; i++) {
                        System.out.print(arr[i] + " ");
                    }
                    System.out.println();
                    break;
                case 8:
                    System.out.print("Vui lòng nhập giá trị cần chèn: ");
                    int value = sc.nextInt();
                    System.out.print("Vui lòng nhập vị trí cần chèn: ");
                    int position = sc.nextInt();
                    if (position < 0 || position > n) {
                        System.out.println("Vị trí không hợp lệ!");
                        break;
                    }
                    for (int i = n; i > position; i--) {
                        arr[i] = arr[i - 1];
                    }
                    arr[position] = value;
                    n++;
                    System.out.print("Mảng sau khi chèn: ");
                    for (int i = 0; i < n; i++) {
                        System.out.print(arr[i] + " ");
                    }
                    System.out.println();
                    break;
                case 9:
                    System.out.println("Thoát chương trình!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập lại.");
            }
        } while (choice != 9);
        sc.close();
    }
}
