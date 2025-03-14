package Ex8;

public class Animals {
    private String name;
    private int age;

    public Animals(String name, int age) {
        if (name == null || name.isEmpty() || age < 0) {
            throw new IllegalArgumentException("Invalid input");
        }
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Invalid name");
        }
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Invalid age");
        }
        this.age = age;
    }

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    public String makeSound() {
        return "Some generic sound";
    }
}
