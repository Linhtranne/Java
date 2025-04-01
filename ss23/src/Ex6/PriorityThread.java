package Ex6;

    public class PriorityThread extends Thread {
    public PriorityThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(getName() + " đang chạy với độ ưu tiên " + getPriority());
        }
    }
}