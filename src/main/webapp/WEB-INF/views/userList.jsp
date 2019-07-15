<%--
  Created by IntelliJ IDEA.
  User: maciej
  Date: 06.06.19
  Time: 09:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script src="<c:url value="/webjars/jquery/3.0.0/jquery.min.js"/>"></script>
    <script src="<c:url value="/webjars/bootstrap/4.3.1/js/bootstrap.min.js"/>"></script>
    <link href="<c:url value="/webjars/bootstrap/4.3.1/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/main.css"/>" rel="stylesheet">
    <script>
        function confirmDelete(id, name) {
            if (confirm("Do you want to delete a pl.coderslab.user '" + name + "'?")) {
                window.location.href = "/users/delete/" + id;
            }
        }
    </script>
</head>
<body>

<a href="/users/add"></a>

<br><br>

<table border="1" align="center">
    <tr>
        <th>First name</th>
        <th>Last name</th>
        <th>Actions</th>
    </tr>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.firstname}</td>
            <td>${user.lastname}</td>
            <td>
                <a href="/users/update/${pl.coderslab.user.id}">Edit</a>
                <a href="#" onclick="confirmDelete(${pl.coderslab.user.id}, '${pl.coderslab.user.fullName}')">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>