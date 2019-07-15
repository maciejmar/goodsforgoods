<%--
  Created by IntelliJ IDEA.
  User: maciej
  Date: 07.06.19
  Time: 12:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
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


        </tr>
    </c:forEach>
</table>
</body>
</html>
