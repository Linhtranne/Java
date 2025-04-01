package Ex5;

public class Writer extends Thread {
    private SharedData sharedData;

    public Writer(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            sharedData.writeMessage("Hehehe!");
            System.out.println("Tin nhắn đã gửi.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}