package Ex9;

class Bike extends Vehicle {
    @Override
    void move() {
        System.out.println("Xe đạp di chuyển với tốc độ chậm.");
    }

    @Override
    void sound() {
        System.out.println("Xe đạp phát ra âm thanh: Ring Ring");
    }
}
