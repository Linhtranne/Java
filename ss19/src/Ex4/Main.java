package Ex4;

// src/Main.java
public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(1);
        System.out.println("Diện tích của hình tròn: " + circle.area());
        IShape.description();
    }
}