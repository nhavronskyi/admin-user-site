<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Message Page</title>
    <link rel="stylesheet" href="index.css">
</head>
<body>
<c:set var="message" value="${requestScope.message}"/>
<div class="wrapper">
    <div class="text-center mt-4 name">
        <div>
            <h3>${message}>
            </h3>
        </div>
        <div class="text-center fs-6">
            <a href="index.jsp">start page</a>
        </div>
    </div>
</div>
</body>
</html>
