<%--
  Created by IntelliJ IDEA.
  User: maciej
  Date: 06.06.19
  Time: 07:09
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="<c:url value="/webjars/jquery/3.0.0/jquery.min.js"/>"></script>
    <script src="<c:url value="/webjars/bootstrap/4.3.1/js/bootstrap.min.js"/>"></script>
    <link href="<c:url value="/webjars/bootstrap/4.3.1/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/main.css"/>" rel="stylesheet">
    <script>
        function confirmDelete(id, name) {
            if (confirm("Do you want to delete a item '" + name + "'?")) {
                window.location.href = "/items/delete/" + id;
            }
        }
    </script>
</head>
<body>

<%@include file="/WEB-INF/views/header.jspf"%>

<div class="container">

    <header>Items</header>

    <div class="card">
        <div class="card-body">
            <a href="/items/add" class="btn btn-primary">Add item</a>
        </div>
    </div>

    <div class="card mt-4">
        <div class="card-body">

            <table class="table table-hover">
                <tr>
                    <th>Name</th>
                    <th>Description</th>
                    <th>photo</th>
                    <th style="width:17%">Action</th>
                </tr>
                <c:forEach items="${items}" var="item">
                    <tr>
                        <td>${item.name}</td>
                        <td>${item.description}</td>
                        <td><img src="/resources/css/image/9.jpg" width="140" height="140"></td>
                        <td>
                            <a href="/items/select/${item.id}" class="btn btn-success">Try!</a>
                            <a href="/items/update/${item.id}" class="btn btn-success">Edit</a>
                            <a href="#" onclick="confirmDelete(${item.id}, '${item.name}')" class="btn btn-danger">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>

        </div>
    </div>

</div>

</body>
</html>