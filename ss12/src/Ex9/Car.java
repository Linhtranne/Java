package Ex9;

class Car extends Vehicle {
    @Override
    void move() {
        System.out.println("Xe di chuyển trên mặt đất.");
    }

    @Override
    void sound() {
        System.out.println("Xe phát ra âm thanh: Vroom");
    }
}

