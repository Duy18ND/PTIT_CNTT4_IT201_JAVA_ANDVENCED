package SESSION13.demo.DAO.category;

import SESSION13.demo.entity.Category;

import java.util.List;

public interface CategoryDAO {
    List<Category> displayCategory();
    boolean addCategory(Category category);
    boolean updateCategory(Category category);
    boolean deleteCategory(String id);
    List<Category> searchCategory(String Name);
    List<Category> sortCategory(boolean isAsc);
}
