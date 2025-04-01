package Ex1;

public class Threads extends Thread {
    @Override
    public void run() {
        super.run();
        System.out.println("Thread đang chạy "+ this.getName()    );
    }
}