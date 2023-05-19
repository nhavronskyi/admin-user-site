<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
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
                <input type="submit" value="update">
            </form>
        </div>
    </div>
</div>
</body>
</html>
