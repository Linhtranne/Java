package Ex2;

public class Calculator {
    int add(int a,int b){
        return a+b;
    }
    int add(int a, int b, int c){
        return a+b+c;
    }

    public static void main(String[] args) {
        Calculator c = new Calculator();
        System.out.println(c.add(1,2,3));
        System.out.println(c.add(1,2));
    }
}
