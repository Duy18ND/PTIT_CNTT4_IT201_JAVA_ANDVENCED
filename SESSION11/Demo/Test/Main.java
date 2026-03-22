package SESSION11.Demo.Test;

import SESSION11.Demo.entity.Product;
import SESSION11.Demo.repository.ProductRepository;
import SESSION11.Demo.repository.impl.ProductRepositoryImpl;
import java.util.List;

public class Main {
    public static void main(String[] args) { // Đã thêm public
        ProductRepository repo = new ProductRepositoryImpl();
        List<Product> products = repo.findAll();

        if (products.isEmpty()) {
            System.out.println("Danh sách trống hoặc lỗi kết nối!");
        } else {
            System.out.println("--- DANH SÁCH SẢN PHẨM ---");
            for (Product p : products) {
                System.out.println(p);
            }
        }
    }
}