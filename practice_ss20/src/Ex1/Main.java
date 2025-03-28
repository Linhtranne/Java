package Ex1;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int choice;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("1. Danh sách sản phẩm");
            System.out.println("2. Thêm mới sản phẩm");
            System.out.println("3. Cập nhật sản phẩm");
            System.out.println("4. Xóa sản phẩm theo ID");
            System.out.println("5. Tìm sản phẩm theo tên");
            System.out.println("6. Lọc sản phẩm theo điều kiện");
            System.out.println("7. Sắp xếp sản phẩm theo giá");
            System.out.println("8. Thoát");
            System.out.print("Chọn chức năng: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    ProductBusiness.listProducts();
                    break;
                case 2:
                    ProductBusiness.addProduct(scanner);
                    break;
                case 3:
                    ProductBusiness.updateProduct(scanner);
                    break;
                case 4:
                    ProductBusiness.deleteProductById(scanner);
                    break;
                case 5:
                    ProductBusiness.searchProductByName(scanner);
                    break;
                case 6:
                    ProductBusiness.filterProducts(scanner);
                    break;
                case 7:
                    ProductBusiness.sortProducts(scanner);
                    break;
                case 8:
                    System.out.println("Thoát chương trình.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
                    break;
            }
        } while (true);
    }
}