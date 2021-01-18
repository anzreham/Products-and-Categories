<%--
  Created by IntelliJ IDEA.
  User: great
  Date: 1/12/2021
  Time: 9:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" />
    <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-light bg-light">
    <a class="navbar-brand" href="/songs">Dashboard</a>
</nav>
<div>

    <div class="row">
        <div class="col">
            <h1>Products</h1>
            <ul>
                <c:forEach items="${category.products}" var="product">
                    <li>${product.name}</li>
                </c:forEach>
            </ul>
        </div>
        <div class="col">
            <form:form method="POST" action="/products/addCatTopro" modelAttribute="categoryProduct">
                <form:input type="hidden" path="product" value="${category.id}" />
                <div class="form-group row">
                    <form:label path="category" class="col-sm-2 col-form-label">Add Product:</form:label>
                    <form:errors path="category" />
                    <div class="col-sm-10">
                        <form:select class="form-control" path="category">
                            <c:forEach items="${ProducysNotContainCat}" var="p">
                                <form:option value="${p.id}">${p.name}</form:option>
                            </c:forEach>
                        </form:select>
                        <form:errors class="small" path="category" />
                    </div>

                </div>

                <button>Add</button>

            </form:form>
        </div>
    </div>


</div>
</body>
</html>
