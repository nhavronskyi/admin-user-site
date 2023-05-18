<%@ page import="com.example.adminusersite.dao.UserDao" %>
<%@ page import="com.example.adminusersite.user.User" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="index.css">
</head>
<body>
<%
    UserDao userDao = (UserDao) request.getAttribute("dao");
    var users = userDao.findAll();
%>

<div class="wrapper">
    <div class="text-center mt-4 name">
        <div>
            <table>
                <tr>
                    <td>id</td>
                    <td>name</td>
                    <td>password</td>
                    <td>type</td>
                </tr>
                <%
                    for (User u : users) {
                %>

                <tr>
                    <td><%=u.getId()%>
                    </td>
                    <td><%=u.getU_name() %>
                    </td>
                    <td><%=u.getU_pass()%>
                    </td>
                    <td><%=u.getU_type()%>
                    </td>
                </tr>
                <%
                    }
                %>
            </table>
            <br>
            <a href="create.jsp">create</a>
            <a href="delete.jsp">delete</a>
            <a href="update.jsp">update</a>
        </div>
        <div class="text-center fs-6">
            <a href="index.jsp">start page</a>
        </div>
    </div>
</div>
</body>
</html>
