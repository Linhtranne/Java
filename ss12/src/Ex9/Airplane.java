package Ex9;

class Airplane extends Vehicle {
    int altitude;
    Airplane(int altitude) {
        this.altitude = altitude;
    }
    @Override
    void move() {
        System.out.println("Máy bay di chuyển trên không ở độ cao: " + altitude + " mét.");
    }
    @Override
    void sound() {
        System.out.println("Máy bay phát ra âm thanh: Whoosh");
    }
}
