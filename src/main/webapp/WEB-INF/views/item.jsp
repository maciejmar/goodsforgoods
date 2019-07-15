<%--
  Created by IntelliJ IDEA.
  User: maciej
  Date: 05.06.19
  Time: 10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="<c:url value="/webjars/jquery/3.0.0/jquery.min.js"/>"></script>
    <script src="<c:url value="/webjars/bootstrap/4.3.1/js/bootstrap.min.js"/>"></script>
    <link href="<c:url value="/webjars/bootstrap/4.3.1/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/main.css"/>" rel="stylesheet">
</head>
<body>

<%@include file="header.jspf" %>

<div class="container">

    <header>Add item</header>

    <div class="card">
        <div class="card-body">
            <a href="/items/list" class="btn btn-primary">Back</a>
        </div>
    </div>

    <div class="card mt-4">

        <div class="card-header">
            Item data
        </div>

        <div class="card-body">

            <form:form method="post" modelAttribute="item">
                <form:hidden path="proposition"/>

                <div class="row">
                    <div class="form-group col-md-6">
                        <label for="nameId">Name:</label>
                        <form:input type="text" path="name" id="nameId" class="form-control"/>
                        <form:errors path="name" element="div" cssClass="error"/>
                    </div>



                </div>

                <div class="form-group">
                    <label for="descriptionId">Description:</label>
                    <form:textarea rows="3" cols="60" path="description" id="descriptionId" class="form-control"/>
                    <form:errors path="description" element="div" cssClass="error"/>
                </div>

                <input type="submit" value="Send" class="btn btn-primary">
            </form:form>

        </div>
    </div>

</div>
</body>
</html>