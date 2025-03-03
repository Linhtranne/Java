import java.util.Scanner;
public class Ex7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập giờ");
        int hour = scanner.nextInt();
        System.out.println("Nhập phút");
        int minute = scanner.nextInt();
        System.out.println("Nhập giây");
        int second = scanner.nextInt();
        System.out.println("Nhập số giờ cần thêm vào");
        int addHour = scanner.nextInt();
        System.out.println("Nhập số phút thêm vào");
        int addMinute = scanner.nextInt();
        System.out.println("Nhập số giây thêm vào");
        int addSecond = scanner.nextInt();
        int totalSecond = second + addSecond;
        int totalMinute = minute + addMinute;
        int totalHour = hour + addHour;
        if (totalSecond >= 60) {
            totalSecond = totalSecond % 60;
            totalMinute++;
        }
        if (totalMinute >= 60) {
            totalMinute = totalMinute % 60;
            totalHour++;
        }
        System.out.println("Thời gian lúc đầu là"  + hour +"Giờ" + ":"  + minute +"Phút" +  ":"  + second + "Giây");
        System.out.println("Thời gian lúc sau là"+ totalHour +"Giờ" + ":"  + totalMinute +"Phút" +  ":"  + totalSecond + "Giây");
    }
}
