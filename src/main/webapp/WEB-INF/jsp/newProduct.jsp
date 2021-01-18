<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
    <link rel="stylesheet" href="css/main.css" />
    <title>Dojos n Ninjas</title>
</head>
<body>
<nav class="navbar navbar-light bg-light">
    <a class="navbar-brand" href="/">Dashboard</a>
</nav>
<div class="container">
    <h1>Dojos N Ninjas</h1>
    <hr />
    <h2>Add a Dojo</h2>
    <form:form action="/products" method="post" modelAttribute="product">
        <div class="form-group">
            <form:label path="name">Dojo Name</form:label>
            <form:errors path="name"/>
            <form:input class="form-control" path="name"/>
        </div>

        <div class="form-group">
            <form:label path="description">Description</form:label>
            <form:errors path="description"/>
            <form:textarea class="form-control" path="description"/>
        </div>

        <div class="form-group">
            <form:label path="price">price</form:label>
            <form:errors path="price"/>
            <form:input class="form-control" path="price"/>
        </div>

        <button>create</button>
    </form:form>
</div>
</body>
</html>