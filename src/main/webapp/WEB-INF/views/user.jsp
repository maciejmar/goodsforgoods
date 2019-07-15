<%--
  Created by IntelliJ IDEA.
  User: maciej
  Date: 05.06.19
  Time: 15:30
  To change this template use File | Settings | File Templates.
--%>




<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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

    <form:form method="post" modelAttribute="user">

        <header>Add user</header>

        <div class="card">
            <div class="card-body">

                <div class="form-group">
                    <label for="firstnameId">Firstname:</label>
                    <form:input type="text" path="firstname" id="firstnameId" class="form-control"/>
                    <form:errors path="firstname" element="div" cssClass="error"/>
                </div>

                <div class="form-group">
                    <label for="lastnameId">Lastname:</label>
                    <form:input type="text" path="lastname" id="lastnameId" class="form-control"/>
                    <form:errors path="lastname" element="div" cssClass="error"/>
                </div>

                <div class="form-group">
                    <label for="passwordId">Password:</label>
                    <form:input type="password" path="password" id="passwordId" class="form-control"/>
                    <form:errors path="password" element="div" cssClass="error"/>
                </div>

                <div class="form-group">
                    <label for="emailId">Email:</label>
                    <form:input type="text" path="email" id="emailId" class="form-control"/>
                        <form:errors path="email" element="div" cssClass="error"/>
                </div>

                <input type="submit" value="Save" class="btn btn-primary">

            </div>
        </div>

    </form:form>

</div>
</body>
</html>
