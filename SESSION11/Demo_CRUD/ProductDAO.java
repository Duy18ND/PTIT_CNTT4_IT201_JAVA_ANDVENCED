package SESSION11.Demo_CRUD;

import java.util.List;

public interface ProductDAO {
    List<Product> getProduct();
    boolean addProduct(Product product);
    boolean edit(Integer proId,Product product);
    boolean delete(Integer proId);
}
