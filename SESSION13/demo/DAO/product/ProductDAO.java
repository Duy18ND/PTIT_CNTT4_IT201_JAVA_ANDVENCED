package SESSION13.demo.DAO.product;

import SESSION13.demo.entity.Product;

import java.util.List;

public interface ProductDAO {
    List<Product> displayProduct();
    boolean addProduct(Product product);
    boolean updateProduct(Product product);
    Product searchProduct(int id);
    boolean deleteProduct(int id);
    List<Product> sortProduct(boolean isAsc);

}
