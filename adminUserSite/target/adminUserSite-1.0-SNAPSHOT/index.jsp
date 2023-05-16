<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Registration page" %>
</h1>
<br/>
<form action="register" method="post">
    login: <label for="login"></label><input type="text" id="login" name="login"><br>
    password: <label for="password"></label><input type="password" id="password" name="password"><br>
    <input type="submit" value="register">
    <br>
    <a href="login.jsp">already registered</a>
</form>
</body>
</html>