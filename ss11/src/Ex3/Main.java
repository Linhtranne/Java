package Ex3;

public class Main {
    public static void main(String[] args) {
        Car c1= new Car("Mẹc",22);
        Bike b1 = new Bike("Air",3);
        b1.displayInfo();
        b1.start();
        c1.displayInfo();
        c1.start();
    }

}
