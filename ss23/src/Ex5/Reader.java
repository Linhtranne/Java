package Ex5;

public class Reader extends Thread {
    private SharedData sharedData;

    public Reader(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Override
    public void run() {
        try {
            String message = sharedData.readMessage();
            System.out.println("Tin nhắn nhận: " + message);
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }
    }
}