package Ex5;
public class Main {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];

        shapes[0] = new Circle(4);
        shapes[1] = new Rectangle(5, 10);
        shapes[2] = new Square(6);

        for (int i = 0; i < shapes.length; i++) {
            System.out.println("Diện tích hình thứ " + (i + 1) + " là: " + shapes[i].area());
        }
    }
}


