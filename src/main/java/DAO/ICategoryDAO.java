package DAO;

import model.Category;
import model.Products;

import java.util.List;

public interface ICategoryDAO {
    public void insertCategory(Category category) ;

    public Category selectCategory(int id);

    public List<Category> selectAllCategory();

    public boolean deleteCategory(int id) ;

    public boolean updateCategory(Category category) ;
}
