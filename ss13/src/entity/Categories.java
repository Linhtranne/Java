package entity;
import java.util.Scanner;

public class Categories implements IApp {
    private static int counter = 1;
    private int categoryId;
    private String name;
    private int priority;
    private String description;
    private boolean status;

    public Categories() {
        this.categoryId = counter++;
    }

    public Categories(String categoryName, int priority, String description, boolean status) {
        this.categoryId = counter++;
        this.name = categoryName;
        this.priority = priority;
        this.description = description;
        this.status = status;
    }

    public String getName() {
        return name;
    }
    public int getId() {
        return categoryId;
    }
    public void setName(String name) {
        if(name.length()>6 && name.length()<50){
            this.name = name;
        }else {
            System.out.println("Tên ko hợp lệ");
        }
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        if(description.length()<255){
            this.description = description;
        }else {
            System.out.println("Mô tả không hợp lệ");
        }
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    @Override
    public void inputData(Scanner scanner) {
        System.out.print("Nhập tên danh mục: ");
        this.name = scanner.nextLine();
        System.out.print("Độ ưu tiên của danh mục: ");
        this.priority = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Mô tả: ");
        this.description = scanner.nextLine();
        System.out.print("Trạng thái");
        this.status = scanner.nextBoolean();
    }

    @Override
    public void displayData() {
        System.out.println(" ID: " + categoryId);
        System.out.println("tên danh mục: " + name);
        System.out.println("Độ ưu tiên: " + priority);
        System.out.println("Mô tả: " + description);
        System.out.println("Trạng thái: " + (status ? "Active" : "Inactive"));
    }
}

