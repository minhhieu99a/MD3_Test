package DAO;

import model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CategoryDAO implements ICategoryDAO {
    public static final String SELECT_FROM_CATEGORY_WHERE_ID = "SELECT  * FROM Category WHERE  Id =?";
    Connection connection = ConnectionJDBC.getConnect();

    @Override
    public void insertCategory(Category category) {

    }

    @Override
    public Category selectCategory(int id) {
        return null;
    }

    @Override
    public List<Category> selectAllCategory() {
        return null;
    }

    @Override
    public boolean deleteCategory(int id) {
        return false;
    }

    @Override
    public boolean updateCategory(Category category) {
        return false;
    }

    public Category findById(int id) {
        Category category = null;
        try(
                PreparedStatement statement = connection.prepareStatement(SELECT_FROM_CATEGORY_WHERE_ID);
                ) {
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                String name = resultSet.getString("name");
                category = new Category(id,name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }

}
