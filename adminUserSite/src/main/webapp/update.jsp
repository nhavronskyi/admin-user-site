<%--
  Created by IntelliJ IDEA.
  User: nhawronsky
  Date: 16.05.2023
  Time: 12:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="update" method="post">
    new login: <label for="login"></label><input type="text" id="login" name="login"><br>
    new password: <label for="password"></label><input type="password" id="password" name="password"><br>
    id: <label for="id"></label><input type="text" id="id" name="id"><br>
    <input type="submit" value="update">
</form>
</body>
</html>
