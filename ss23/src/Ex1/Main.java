package Ex1;

public class Main {
    public static void main(String[] args) {
        Thread m1= new Threads();
        Thread m2= new Threads();
        m1.setName("m1");
        m2.setName("m2");
        m1.start();
        m2.start();
    }
}