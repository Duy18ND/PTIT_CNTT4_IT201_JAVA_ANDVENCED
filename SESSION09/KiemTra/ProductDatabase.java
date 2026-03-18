package SESSION09.KiemTra;
import java.util.ArrayList;
import java.util.List;

public class ProductDatabase {
    private List<Product> productList;
    private static ProductDatabase instance;

    private ProductDatabase() {
        productList = new ArrayList<>();
    }
    public static ProductDatabase getInstance(){
        if(instance == null){
            instance = new ProductDatabase();
        }
        return instance;
    }

    //Add
    public void addProduct(Product p) {
        productList.add(p);
    }
    public Product findById(String id) {
        for (Product p : productList) {
            if (p.getId().equalsIgnoreCase(id)){
                return p;
            }
        }
        return null;
    }

    public void deleteProduct(Product p) {
        productList.remove(p);
    }

    public List<Product> getAllProducts() {
        return productList;
    }
}
