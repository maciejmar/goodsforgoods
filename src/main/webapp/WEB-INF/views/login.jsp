<%--
  Created by IntelliJ IDEA.
  User: maciej
  Date: 05.06.19
  Time: 14:57
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
</head>
<body>

<div class="container">

    <form method="post">

        <header>Login</header>

        <div class="card">
            <div class="card-body">

                <div class="form-group">
                    <label for="emailId">Email:</label>
                    <input type="text" name="email" id="emailId" class="form-control">
                </div>

                <div class="form-group">
                    <label for="passwordId">Password:</label>
                    <input type="password" name="password" id="passwordId" class="form-control">
                </div>

                <c:if test="${isLogged == false}">
                    <div class="error">Login failed</div>
                    <br><br>
                </c:if>

                <input type="submit" value="Login" class="btn btn-primary">
                <a href="/users/add" class="btn btn-primary">Register</a>

            </div>
        </div>

    </form>

</div>
</body>
</html>