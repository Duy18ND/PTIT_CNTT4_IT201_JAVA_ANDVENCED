package SESSION05.miniproject;

import java.util.ArrayList;
import java.util.List;

public class Product {
    public record Products(int id, String name, double price, int quantity, String category) {}

    private List<Products> productList = new ArrayList<>();

    public void add(Products dataNew) {
        productList.add(dataNew);
        System.out.println("Đã thêm sản phẩm thành công!");
    }

    public void display() {
        if (productList.isEmpty()) {
            System.out.println("Danh sách sản phẩm đang trống.");
            return;
        }
        for (Products p : productList) {
            System.out.println("ID: " + p.id() + " | Tên: " + p.name() + " | Giá: " + p.price() + " | SL: " + p.quantity() + " | Danh mục: " + p.category());
        }
    }

    public void update(int id, int newQuantity) {
        for (int i = 0; i < productList.size(); i++) {
            Products currentProduct = productList.get(i);
            if (currentProduct.id() == id) {
                Products updatedProduct = new Products(
                        currentProduct.id(),
                        currentProduct.name(),
                        currentProduct.price(),
                        newQuantity,
                        currentProduct.category()
                );
                productList.set(i, updatedProduct);
                System.out.println("Đã cập nhật số lượng thành công!");
                return;
            }
        }
        System.out.println("Lỗi: Không tìm thấy sản phẩm mang ID " + id);
    }

    public void delete() {
        boolean isRemoved = productList.removeIf(p -> p.quantity() == 0);
        if (isRemoved) {
            System.out.println("Đã dọn dẹp các sản phẩm hết hàng!");
        } else {
            System.out.println("Không có sản phẩm nào đang hết hàng.");
        }
    }
}