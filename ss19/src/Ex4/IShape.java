package Ex4;

public interface IShape {
    default double area() {
        return 0;
    }

    static void description() {
        System.out.println("Đây là 1 hình");
    }
}