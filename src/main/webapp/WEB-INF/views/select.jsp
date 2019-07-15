<%--
  Created by IntelliJ IDEA.
  User: maciej
  Date: 06.06.19
  Time: 23:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

    <style type="text/css">
        body {text-align: center }

    </style>

    <title>Select</title>
    <script src="<c:url value="/webjars/jquery/3.0.0/jquery.min.js"/>"></script>
    <script src="<c:url value="/webjars/bootstrap/4.3.1/js/bootstrap.min.js"/>"></script>
    <link href="<c:url value="/webjars/bootstrap/4.3.1/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/main.css"/>" rel="stylesheet">

</head>
<body>

<a href="/items/tran" align="center">Start transaction!</a>

<br><br>

<table border="1" align="center">
    <tr>
        <th>Name:</th>
        <th>Description:</th>
    </tr>
    <img style="margin:auto;display:block;text-align:center" src="/resources/css/image/9.jpg">


    <tr>
         <td>${item.name}</td>
        <td>${item.description}</td>
    </tr>
</table>
</body>
</html>
