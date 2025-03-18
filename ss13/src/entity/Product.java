// Class Product
package entity;
import java.util.Scanner;

public class Product implements IApp {
    private String productId;
    private String name;
    private float importPrice;
    private float exportPrice;
    private String title;
    private String description;
    private int quantity;
    private int categoryId;
    private int status;

    public Product() {}
    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        while (exportPrice < importPrice * INTEREST) {
            System.out.print("Giá xuất phải lớn hơn hoặc bằng " + INTEREST + " lần giá nhập!: ");
            exportPrice = new Scanner(System.in).nextFloat();
        }
        this.exportPrice = exportPrice;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        while (importPrice <= 0) {
            System.out.print("Giá nhập phải lớn hơn 0!: ");
            importPrice = new Scanner(System.in).nextFloat();
        }
        this.importPrice = importPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        while (name.length() < 10 || name.length() > 100) {
            System.out.print("Tên sản phẩm phải từ 10 đến 100 ký tự! : ");
            name = new Scanner(System.in).nextLine();
        }
        this.name = name;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        while (!productId.matches("[CET]\\d{4}")) {
            System.out.print("Mã sản phẩm phải có định dạng C/E/T + 4 chữ số!: ");
            productId = new Scanner(System.in).nextLine();
        }
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        while (quantity < 0) {
            System.out.print("Số lượng không thể âm!: ");
            quantity = new Scanner(System.in).nextInt();
        }
        this.quantity = quantity;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        while (status < 0 || status > 2) {
            System.out.print("Trạng thái phải là 0 (Hoạt động), 1 (Hết hàng) hoặc 2 (Không hoạt động)! Nhập lại: ");
            status = new Scanner(System.in).nextInt();
        }
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        while (title.length() > 200) {
            System.out.print("Tiêu đề không được vượt quá 200 ký tự: ");
            title = new Scanner(System.in).nextLine();
        }
        this.title = title;
    }
    @Override
    public void inputData(Scanner scanner) {
        System.out.print("Nhập ID sản phẩm: ");
        this.productId = scanner.nextLine();
        System.out.print("Nhập tên sản phẩm: ");
        this.name = scanner.nextLine();
        System.out.print("Giá nhập sản phẩm: ");
        this.importPrice = scanner.nextFloat();
        do {
            System.out.print("Giá bán sản phẩm ( " + (importPrice * INTEREST) + "): ");
            this.exportPrice = scanner.nextFloat();
        } while (this.exportPrice < importPrice * INTEREST);
        scanner.nextLine();
        System.out.print("Nhập tiêu đề: ");
        this.title = scanner.nextLine();
        System.out.print("Nhập mô tả: ");
        this.description = scanner.nextLine();
        System.out.print("Nhập số lượng: ");
        this.quantity = scanner.nextInt();
        System.out.print("Nhập ID của danh mục: ");
        this.categoryId = scanner.nextInt();
        System.out.print("Trạng thái: ");
        this.status = scanner.nextInt();
    }

    @Override
    public void displayData() {
        System.out.println("ID sản phẩm: " + productId);
        System.out.println("tên sản phẩm: " + name);
        System.out.println("Giá nhập sản phẩm: " + importPrice);
        System.out.println("Giá bán sản phẩm " + exportPrice);
        System.out.println("tiêu đề: " + title);
        System.out.println(" mô tả: " + description);
        System.out.println(" số lượng: " + quantity);
        System.out.println("Nhập ID của danh mục: " + categoryId);
        System.out.println("Trạng thái: " + (status == 0 ? "Active" : status == 1 ? "Out of stock" : "Inactive"));
    }
}

