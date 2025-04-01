
package Ex4;

public class Threads extends Thread {
    private int threadNumber;
    private Thread threadToJoin;

    public Threads(int threadNumber, Thread threadToJoin) {
        this.threadNumber = threadNumber;
        this.threadToJoin = threadToJoin;
    }

    @Override
    public void run() {
        try {
            if (threadToJoin != null) {
                threadToJoin.join();
            }

            switch (threadNumber) {
                case 1:
                    for (int i = 1; i <= 5; i++) {
                        System.out.println(i);
                        Thread.sleep(1000);
                    }
                    break;
                case 2:
                    System.out.println("Thread 2 bắt đầu...");
                    break;
                case 3:
                    System.out.println("Thread 3 bắt đầu...");
                    break;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}