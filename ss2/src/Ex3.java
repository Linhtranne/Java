public class Ex3 {
    public static void main(String[] args) {
        int x =4;
        int y =9;
        System.out.println(x != y);
        System.out.println(x == y);
        System.out.println(x >= y);
        System.out.println(x <= y);
        System.out.println(x > y);
        System.out.println(x < y);

        if(x >y){
            System.out.println("x lớn hơn y");
        } else if (x < y) {
            System.out.println("x nhỏ hơn y");
        }else{
            System.out.println("x bằng y");
        }
    }
}
