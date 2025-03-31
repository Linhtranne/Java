package Ex10;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<CartItem> cartItems;

    public ShoppingCart() {
        this.cartItems = new ArrayList<>();
    }

    public void addToCart(Product product, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Lỗi: Số lượng không hợp lệ!");
        }
        for (CartItem item : cartItems) {
            if (item.getProduct().getId().equals(product.getId())) {
                item.setQuantity(item.getQuantity() + quantity);
                return;
            }
        }
        cartItems.add(new CartItem(product, quantity));
    }

    public void removeFromCart(String productId) {
        for (CartItem item : cartItems) {
            if (item.getProduct().getId().equals(productId)) {
                cartItems.remove(item);
                return;
            }
        }
        throw new IllegalArgumentException("Lỗi: Không tìm thấy sản phẩm trong giỏ hàng!");
    }

    public void displayCart() {
        if (cartItems.isEmpty()) {
            System.out.println("Giỏ hàng trống.");
            return;
        }
        for (CartItem item : cartItems) {
            System.out.println("Sản phẩm: " + item.getProduct().getName() + ", Số lượng: " + item.getQuantity() + ", Giá: " + item.getTotalPrice());
        }
    }

    public void checkout() {
        double total = 0;
        for (CartItem item : cartItems) {
            total += item.getTotalPrice();
        }
        System.out.println("Tổng tiền cần thanh toán: " + total);
    }
}