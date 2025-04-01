package Ex4;

public class Main {
    public static void main(String[] args) {
        Threads thread1 = new Threads(1, null);
        Threads thread2 = new Threads(2, thread1);
        Threads thread3 = new Threads(3, thread1);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}