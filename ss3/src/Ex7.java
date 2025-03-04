import java.util.Scanner;
public class Ex7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập cạnh thứ nhất");
        int first = scanner.nextInt();
        System.out.println("Nhập cạnh thứ hai");
        int second = scanner.nextInt();
        System.out.println("Nhập cạnh thứ ba");
        int third = scanner.nextInt();
        if ((first + second > third) && (first + third > second) && (second + third > first)
        ){
            System.out.println("Ba cạnh không tạo thành tam giác");
        }else{
            if(first == second && second == third){
                System.out.println("Tam giác đều");
            }else if(first == second || second == third || first == third){
                System.out.println("Tam giác cân");
            }else if(first*first + second*second == third*third || first*first + third*third == second*second || second*second + third*third == first*first){
                System.out.println("Tam giác vuông");
            }else{
                System.out.println("Tam giác thường");
            }
        }
        scanner.close();
    }
}
