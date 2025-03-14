package Ex8;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Animals> animals = new ArrayList<>();

        try {
            animals.add(new Dog("Bình", 3, "Vàng"));
            animals.add(new Cat("Thiều", 2, "Đen"));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        for (Animals animal : animals) {
            animal.displayInfo();
            System.out.println("Âm thanh: " + animal.makeSound());
            System.out.println();
        }
    }
}