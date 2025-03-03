
public class Ex4 {
    public static void main(String[] args) {
        boolean a = true;
        boolean b = true;
        boolean c = false;

        if (a && b) {
            System.out.println("Cả hai đều đúng");
        }
        if (a || b) {
            System.out.println("Ít nhất một đúng");
        }
        if (!a && b) {
            System.out.println("Không đúng");
        }
        System.out.println("Giá trị ban đầu của c: " + c);
        c = !c;
        System.out.println("Giá trị sau khi đảo ngược của c: " + c);

        if ((a && c) || (b && !c)) {
            System.out.println("Điều kiện logic phức tạp đúng");
        } else {
            System.out.println("Điều kiện logic phức tạp sai");
        }
    }
}
