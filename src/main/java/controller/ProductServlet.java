package controller;

import DAO.CategoryDAO;
import DAO.ProductDAO;
import model.Category;
import model.Products;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/ProductServlet")
public class ProductServlet extends HttpServlet {
    private ProductDAO productDAO = new ProductDAO();
    private CategoryDAO categoryDAO = new CategoryDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                showNewProductForm(request, response);
                break;
            case "search":
                showFormFindByName(request,response);
                break;
            case "delete":
                deleteProduct(request,response);
            default:
                showAllProducts(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                addProduct(request, response);
                break;
            case "search":
                findByName(request,response);
                break;
        }
    }

    private void showAllProducts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Products> products = productDAO.selectAllUsers();
        request.setAttribute("listProducts", products);
        RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewProductForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("add.jsp");
        dispatcher.forward(request, response);
    }

    private void addProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        Double price = Double.valueOf((request.getParameter("price")));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String color = request.getParameter("color");
        String describtion = request.getParameter("description");
        int idC = Integer.parseInt(request.getParameter("idC"));
        Category category = categoryDAO.findById(idC);
        Products products = new Products(name, price, quantity, color, describtion, category);
        productDAO.insertProduct(products);
        RequestDispatcher dispatcher = request.getRequestDispatcher("add.jsp");
        dispatcher.forward(request, response);
    }

    private void showFormFindByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("search.jsp");
        dispatcher.forward(request, response);
    }

    private void findByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        List<Products> products = productDAO.findByName(name);
        request.setAttribute("listByName",products);
        RequestDispatcher dispatcher=request.getRequestDispatcher("search.jsp");
        dispatcher.forward(request,response);
    }

    private void deleteProduct (HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {
        int id =Integer.parseInt(request.getParameter("id"));
        productDAO.deleteProduct(id);
        List<Products>products=productDAO.selectAllUsers();
        request.setAttribute("listProducts",products);
        RequestDispatcher dispatcher =request.getRequestDispatcher("list.jsp");
        dispatcher.forward(request,response);
    }
}
