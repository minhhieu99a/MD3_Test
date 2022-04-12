<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 4/12/2022
  Time: 11:16 AM
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
        <a href="/ProductServlet">Back to Home</a>
    </h2>
    <form method="post">
        <input type="text" name="name" size="40" >
        <input type="submit" value="search">
    </form>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Product</h2></caption>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Price</th>
            <th>Color</th>
        </tr>
        <c:forEach var="product" items="${listByName}">
            <tr>
                <td><c:out value="${product.getId()}"/></td>
                <td><c:out value="${product.getName()}"/></td>
                <td><c:out value="${product.getPrice()}"/></td>
                <td><c:out value="${product.getColor()}"/></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
