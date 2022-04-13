<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 4/12/2022
  Time: 9:52 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Product Management Application</title>
</head>
<body>
<center>
    <h1>Product Management</h1>
    <h2>
        <a href="/ProductServlet?action=add">Add New Product</a>
        <br/>
        <a href="/ProductServlet?action=search">Find By Name</a>
        <br/>
        <a href="/ProductServlet?action=sort">Sort List By Name</a>
        <br/>
        <a href="/ProductServlet">Back to HomeTown</a>

    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Product</h2></caption>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Color</th>
            <th>Decribtion</th>
            <th>Name Category</th>
        </tr>
        <c:forEach var="product" items="${listProducts}">
            <tr>
                <td><c:out value="${product.getId()}"/></td>
                <td><c:out value="${product.getName()}"/></td>
                <td><c:out value="${product.getPrice()}"/></td>
                <td><c:out value="${product.getQuantity()}"/></td>
                <td><c:out value="${product.getColor()}"/></td>
                <td><c:out value="${product.getDecribtion()}"/></td>
                <td><c:out value="${product.getCategory().getName()}"/></td>
                <td>
                    <a href="/ProductServlet?action=edit&id=${product.getId()}">Edit</a>
                    <a href="/ProductServlet?action=delete&id=${product.getId()}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>