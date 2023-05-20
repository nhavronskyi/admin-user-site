<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>User Page</title>
    <link rel="stylesheet" href="index.css">
</head>
<body>
<c:set var="user" value="${requestScope.user}"/>
<div class="wrapper">
    <div class="text-center mt-4 name">
        <div>
            <h3 class="text">name: ${user.getU_name()}</h3>
            <span class="text">id: ${user.getId()}</span><br>
            <span class="text">password: ${user.getU_pass()}</span><br>
            <span class="text">type: ${user.getU_type()}</span><br>
        </div>
        <div class="text-center fs-6">
            <a href="index.jsp">logout</a>
        </div>
    </div>
</div>
</body>
</html>