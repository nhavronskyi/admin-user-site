<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1><%= "LOGIN PAGE" %>
</h1>
<form action="sign-in" method="post">
    login: <label for="login"></label><input type="text" id="login" name="login"><br>
    password: <label for="password"></label><input type="password" id="password" name="password"><br>
    <input type="submit" value="sign in">
</form>
</body>
</html>
