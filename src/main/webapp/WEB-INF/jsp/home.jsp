<%--
  Created by IntelliJ IDEA.
  User: great
  Date: 1/13/2021
  Time: 9:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Home</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
    <meta charset="ISO-8859-1">
</head>
<body>
<div class = "container"></div>
<h1>Welcome </h1>

<a href="/products/new">New product  </a>
<br />
<a href="/categories/new">New Category </a>

<h1> products</h1>
<table class="table">
    <thead class="thead-light">
    <tr>
        <th>Name</th>
        <th>Description</th>
        <th>Price</th>
        <th>Categories Count</th>
    </tr>
    </thead>

    <tbody>
    <!-- loop through arraylist -->
    <c:forEach items="${products}" var="product">
        <tr>
            <td><a href="/products/${product.id}">${product.name}</a></td>
            <td>${product.description}</td>
            <td>${product.price}</td>
            <td>${product.categories.size()} </td>
        </tr>

    </c:forEach>
    </tbody>
</table>



    <h1>Categories</h1>

    <table class="table ">
        <thead>
        <tr>
            <th>Name</th>
            <th>Product Count</th>



        </tr>
        </thead>

        <tbody>
        <!-- loop through arraylist -->
        <c:forEach items="${categories}" var="category">
            <tr>
                <td><a href="/categories/${category.id}">${category.name}</a></td>
                <td>${category.products.size()}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>




</body>
</html>