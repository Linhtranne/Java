package Ex2;

public class Main {
    public static void main(String[] args) {
        IAnimal dog = AnimalFactory.getAnimal("Dog");
        IAnimal cat = AnimalFactory.getAnimal("Cat");

        if (dog != null) {
            dog.speak();
        }

        if (cat != null) {
            cat.speak();
        }
    }
}