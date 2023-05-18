<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="index.css">
</head>
<body>
<% String message = (String) request.getAttribute("message");%>

<div class="wrapper">
    <div class="text-center mt-4 name">
        <div>
            <h3><%= message%>
            </h3>
        </div>
        <div class="text-center fs-6">
            <a href="index.jsp">start page</a>
        </div>
    </div>
</div>
</body>
</html>
