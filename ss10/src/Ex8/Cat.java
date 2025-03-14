package Ex8;

public class Cat extends Animals {
    private String furColor;

    public Cat(String name, int age, String furColor) {
        super(name, age);
        if (furColor == null || furColor.isEmpty()) {
            throw new IllegalArgumentException("Màu không hợp lệ");
        }
        this.furColor = furColor;
    }

    public String getFurColor() {
        return furColor;
    }

    public void setFurColor(String furColor) {
        if (furColor == null || furColor.isEmpty()) {
            throw new IllegalArgumentException("Màu không hợp lệ");
        }
        this.furColor = furColor;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Fur Color: " + furColor);
    }

    @Override
    public String makeSound() {
        return "Meow Meow";
    }
}
