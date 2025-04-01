package Ex6;

public class Main {
    public static void main(String[] args) {
        PriorityThread thread1 = new PriorityThread("Thread 1");
        PriorityThread thread2 = new PriorityThread("Thread 2");
        PriorityThread thread3 = new PriorityThread("Thread 3");

        thread1.setPriority(Thread.MIN_PRIORITY);
        thread2.setPriority(Thread.NORM_PRIORITY);
        thread3.setPriority(Thread.MAX_PRIORITY);

        thread1.start();
        thread2.start();
        thread3.start();
        //Mức độ ưu tiên (priority) của các luồng không đảm bảo 100% thứ tự thực hiện giữa chúng. Điều này là do mức độ ưu tiên chỉ là một gợi ý cho bộ lập lịch của hệ điều hành về thứ tự thực hiện các luồng. Bộ lập lịch có thể quyết định thực hiện các luồng theo thứ tự khác nhau dựa trên nhiều yếu tố khác nhau như trạng thái của luồng, tài nguyên hệ thống, và các chính sách lập lịch của hệ điều hành.
    }
}