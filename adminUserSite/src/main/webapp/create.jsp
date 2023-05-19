<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Create User</title>
    <link rel="stylesheet" href="index.css">
</head>
<body>
<div class="wrapper">
    <div class="text-center mt-4 name">
        Registration page
    </div>
    <form class="p-3 mt-3" action="create" method="post">
        <div class="form-field d-flex align-items-center">
            <span class="far fa-user"></span>
            <label for="login"></label><input type="text" name="login" id="login" placeholder="Username">
        </div>
        <div class="form-field d-flex align-items-center">
            <span class="fas fa-key"></span>
            <label for="password"></label><input type="password" name="password" id="password" placeholder="Password">
        </div>
        <button class="btn mt-3" type="submit">Registrate</button>
    </form>
</div>
</body>
</html>
