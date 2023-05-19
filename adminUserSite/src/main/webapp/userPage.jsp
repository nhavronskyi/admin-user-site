<%@ page import="com.example.adminusersite.user.User" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="index.css">
</head>
<body>
<%
    User user = (User) request.getAttribute("user");
%>
<div class="wrapper">
    <div class="text-center mt-4 name">
        <div>
            <h3 class="text"><%="name: " + user.getU_name()%>
            </h3>
            <span class="text"><%= "id:  " + user.getId()%></span><br>
            <span class="text"><%= "password:  " + user.getU_pass()%></span><br>
            <span class="text"><%= "type:  " + user.getU_type()%></span><br>
        </div>
        <div class="text-center fs-6">
            <a href="index.jsp">logout</a>
        </div>
    </div>
</div>
</body>
</html>