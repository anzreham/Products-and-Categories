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

    <h2>New Category </h2>
    <form:form action="/categories" method="post" modelAttribute="category">
        <div class="form-group">
            <form:label path="name"> Name</form:label>
            <form:errors path="name"/>
            <form:input class="form-control" path="name"/>
        </div>





        <button>create</button>
    </form:form>
</div>
</body>
</html>