import java.util.Scanner;

public class Ex8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--------- Nhập thông tin sinh viên ---------");
        System.out.print("Nhập mã sinh viên: ");
        String studentId = scanner.nextLine();
        System.out.print("Nhập tên sinh viên: ");
        String name = scanner.nextLine();
        System.out.print("Nhập số điện thoại: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Nhập ngày sinh (dd/mm/yyyy): ");
        String birthDate = scanner.nextLine();
        System.out.print("Nhập giới tính (1: Nam, 0: Nữ): ");
        int genderInput = scanner.nextInt();
        String gender = (genderInput == 1) ? "Nam" : "Nữ";
        System.out.println("--------- Nhập điểm sinh viên ---------");
        System.out.print("Nhập điểm Toán: ");
        double math = scanner.nextDouble();
        System.out.print("Nhập điểm Vật Lý: ");
        double physics = scanner.nextDouble();
        System.out.print("Nhập điểm Hóa học: ");
        double chemistry = scanner.nextDouble();
        System.out.print("Nhập điểm Sinh học: ");
        double biology = scanner.nextDouble();
        System.out.print("Nhập điểm Ngoại ngữ: ");
        double english = scanner.nextDouble();
        double average = (math + physics + chemistry + biology + english) / 5;
        System.out.println("--------- Hiển thị thông tin sinh viên ---------");
        System.out.println("Mã sinh viên: " + studentId + " | Tên sinh viên: " + name + " | Giới tính: " + gender);
        System.out.println("Ngày sinh: " + birthDate + " | Số điện thoại: " + phoneNumber);
        System.out.printf("Điểm Toán: %.2f | Điểm Vật Lý: %.2f | Điểm Hóa học: %.2f | Điểm Sinh học: %.2f | Điểm Ngoại ngữ: %.2f\n",
                math, physics, chemistry, biology, english);
        System.out.printf("Điểm trung bình: %.2f\n", average);

    }
}
