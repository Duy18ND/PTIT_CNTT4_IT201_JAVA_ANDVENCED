package SESSION11.Demo.repository;

import SESSION11.Demo.entity.Product;
import java.util.List;

public interface ProductRepository {
    List<Product> findAll();
}