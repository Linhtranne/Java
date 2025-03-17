package Ex8;

import java.util.Scanner;

public class Garage {
    private Car[] cars;
    int count;

    public Garage(int capacity) {
        cars = new Car[capacity];
        count = 0;
    }

    public void addCar(Car car) {
        if (count < cars.length) {
            cars[count++] = car;
            System.out.println("Xe đã được thêm vào gara.");
        } else {
            System.out.println("Gara đã đầy!");
        }
    }

    public void startAll() {
        if (count == 0) {
            System.out.println("Gara không có xe nào.");
            return;
        }
        for (int i = 0; i < count; i++) {
            System.out.println(cars[i].start());
        }
    }

    public void stopAll() {
        if (count == 0) {
            System.out.println("Gara không có xe nào.");
            return;
        }
        for (int i = 0; i < count; i++) {
            System.out.println(cars[i].stop());
        }
    }

    public void refuelAll() {
        if (count == 0) {
            System.out.println("Gara không có xe nào.");
            return;
        }
        for (int i = 0; i < count; i++) {
            System.out.println(cars[i].refuel());
        }
    }


}

