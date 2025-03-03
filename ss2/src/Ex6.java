import java.util.Scanner;

public class Ex6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập tên học sinh: ");
        String studentName = scanner.nextLine();

        System.out.print("Nhập điểm môn thứ nhất: ");
        double score1 = scanner.nextDouble();
        System.out.print("Nhập điểm môn thứ hai: ");
        double score2 = scanner.nextDouble();
        System.out.print("Nhập điểm môn thứ ba: ");
        double score3 = scanner.nextDouble();

        double scoreAVG = (score1 + score2 + score3) / 3;

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
        System.out.println("\nTên học sinh: " + studentName);
        System.out.printf("Điểm trung bình: %.2f\n", scoreAVG);
        System.out.println("Xếp loại: " + rating);
    }
}