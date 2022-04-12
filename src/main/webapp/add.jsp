<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 4/12/2022
  Time: 10:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Products Management Application</title>
</head>
<body>
<center>
    <h1>Product Management</h1>
    <h2>
        <a href="ProductServlet?action=ProductServlet">List All Products</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Add New Product</h2>
            </caption>
            <tr>
                <th> Name:</th>
                <td>
                    <input type="text" name="name" id="fullname" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Price:</th>
                <td>
                    <input type="text" name="price" id="price" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Quantity:</th>
                <td>
                    <input type="text" name="quantity" id="quantity" size="15"/>
                </td>
            </tr>
            <tr>
                <th>Color:</th>
                <td>
                    <input type="text" name="color" id="color" size="15"/>
                </td>
            </tr>
            <tr>
                <th>Describtion:</th>
                <td>
                    <input type="text" name="description" id="description" size="45"/>
                </td>
            </tr>
            <tr>
                <th>idC:</th>
                <td>
                    <input type="text" name="idC" id="idC" size="15"/>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
