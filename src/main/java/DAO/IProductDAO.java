package DAO;

import model.Products;

import java.util.List;

public interface IProductDAO {
    public void insertProduct(Products products) ;

    public Products selectProduct(int id);

    public List<Products> selectAllUsers();

    public boolean deleteProduct(int id) ;

    public boolean updateProduct(Products products) ;
}

