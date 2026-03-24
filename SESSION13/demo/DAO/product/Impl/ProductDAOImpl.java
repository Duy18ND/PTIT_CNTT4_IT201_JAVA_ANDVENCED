package SESSION13.demo.DAO.product.Impl;

import SESSION13.demo.DAO.product.ProductDAO;
import SESSION13.demo.entity.Product;

import java.util.List;

public class ProductDAOImpl implements ProductDAO {
    @Override
    public List<Product> displayProduct() {
        return List.of();
    }

    @Override
    public boolean addProduct(Product product) {
        return false;
    }

    @Override
    public boolean updateProduct(Product product) {
        return false;
    }

    @Override
    public Product searchProduct(int id) {
        return null;
    }

    @Override
    public boolean deleteProduct(int id) {
        return false;
    }

    @Override
    public List<Product> sortProduct(boolean isAsc) {
        return List.of();
    }
}
