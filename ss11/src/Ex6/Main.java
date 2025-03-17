package Ex6;

public class Main {
    public static void main(String[] args) {
        Zoo zoo = new Zoo();
        Lion lion = new Lion("Sư tử", 5);
        Elephant elephant = new Elephant("Voi", 10);

        zoo.addAnimal(lion);
        zoo.addAnimal(elephant);

        for (int i = 0; i < zoo.count; i++) {
            zoo.animals[i].sound();
            zoo.animals[i].move();
        }
    }
}
