<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Update User</title>
    <link rel="stylesheet" href="index.css">
</head>

<body>

<% var u = request.getAttribute("id");
%>
<div class="wrapper">
    <div class="text-center mt-4 name">
        <div>
            <form action="update" method="post">
                new login: <label for="login"></label><input type="text" id="login" name="login"><br>
                new password: <label for="password"></label><input type="password" id="password" name="password"><br>
                <input type="hidden" name="id" value="<%= u %>">
                <br>
                <button class="btn mt-3" type="submit">update</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
