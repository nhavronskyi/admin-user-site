<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Autorisation</title>
    <link rel="stylesheet" href="index.css">
</head>
<body>

<div class="wrapper">
    <div class="text-center mt-4 name">
        AdminUserSite
    </div>
    <form class="p-3 mt-3" action="sign-in" method="post">
        <div class="form-field d-flex align-items-center">
            <span class="far fa-user"></span>
            <label for="login"></label><input type="text" name="login" id="login" placeholder="Username">
        </div>
        <div class="form-field d-flex align-items-center">
            <span class="fas fa-key"></span>
            <label for="password"></label><input type="password" name="password" id="password" placeholder="Password">
        </div>
        <button class="btn mt-3" type="submit">Login</button>
    </form>
    <div class="text-center fs-6">
        <a href="register.jsp">Sign up</a>
    </div>
</div>
</body>
</html>