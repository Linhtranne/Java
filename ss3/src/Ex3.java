import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập điểm môn thứ nhất: ");
        double scoreAVG = scanner.nextDouble();
        String rating;
        if (scoreAVG >= 8.0) {
            rating = "Giỏi";
        } else if (scoreAVG >= 6.5) {
            rating = "Khá";
        } else if (scoreAVG >= 5.0) {
            rating = "Trung bình";
        } else {
            rating = "Yếu";
        }
        System.out.printf("Điểm trung bình: %.2f\n", scoreAVG);
        System.out.println("Xếp loại: " + rating);
    }
}