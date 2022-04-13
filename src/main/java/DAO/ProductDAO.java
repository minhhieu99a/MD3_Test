package DAO;

import model.Category;
import model.Products;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements IProductDAO {
    private CategoryDAO categoryDAO = new CategoryDAO();
    public static final String SELECT_FROM_PRODUCT = "SELECT P.Id as 'Id' , P.name as 'name',P.price as 'price',P.quantity as 'quantity',P.color as 'color',P.describtion as 'description',P.idC as'idC' , C.name as 'nameCategory' FROM Product P join Category C on C.Id = P.idC;";
    public static final String INSERT_NEW_PRODUCT = "INSERT INTO Product(name, price, quantity, color, describtion, idC) values (?,?,?,?,?,?)";
    public static final String FIND_PRODUCT_BY_NAME = "SELECT * FROM Product where name =?;";
    Connection connection = ConnectionJDBC.getConnect();

    @Override
    public void insertProduct(Products products) {
        try (
                PreparedStatement statement = connection.prepareStatement(INSERT_NEW_PRODUCT);
        ) {
            statement.setString(1, products.getName());
            statement.setDouble(2, products.getPrice());
            statement.setInt(3, products.getQuantity());
            statement.setString(4, products.getColor());
            statement.setString(5, products.getDecribtion());
            statement.setInt(6, products.getCategory().getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Products selectProduct(int id) {
        return null;
    }

    @Override
    public List<Products> selectAllUsers() {
        List<Products> products = new ArrayList<>();
        try (
                PreparedStatement statement = connection.prepareStatement(SELECT_FROM_PRODUCT);

        ) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("Id");
                String name = resultSet.getString("name");
                Double price = resultSet.getDouble("price");
                int quantity = resultSet.getInt("quantity");
                String color = resultSet.getString("color");
                String describtion = resultSet.getString("description");
                int idC = resultSet.getInt("idC");
                String nameCategory = resultSet.getString("nameCategory");
                Category category = new Category(idC, nameCategory);
                Products product = new Products(id, name, price, quantity, color, describtion, category);
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public boolean deleteProduct(int id) {
        boolean rowProduct = false;
        String query = "{Call DeleteProduct(?)}";
        try (CallableStatement statement = connection.prepareCall(query)) {
            statement.setInt(1,id);
            rowProduct=statement.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowProduct;
    }

    @Override
    public boolean updateProduct(Products products) {
        return false;
    }

    public List<Products> findByName(String name) {
        List<Products> products = new ArrayList<>();
        try (
                PreparedStatement statement = connection.prepareStatement(FIND_PRODUCT_BY_NAME);
        ) {
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("Id");
                double price = resultSet.getDouble("price");
                int quantity = resultSet.getInt("quantity");
                String color = resultSet.getString("color");
                String describtion = resultSet.getString("describtion");
                int idC = resultSet.getInt("idC");
                Category category = categoryDAO.findById(idC);
                Products products1 = new Products(id, name, price, quantity, color, describtion, category);
                products.add(products1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
}
