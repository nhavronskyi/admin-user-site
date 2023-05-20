<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Admin page</title>
    <link rel="stylesheet" href="index.css">
</head>
<body>
<c:set var="userDao" value="${requestScope.dao}"/>

<div class="wrapper">
    <div class="text-center mt-4 name">
        <div>
            <div class="text-center mt-4 name">
                Admin page
            </div>
            <table>
                <tr>
                    <td>id</td>
                    <td>name</td>
                    <td>password</td>
                    <td>type</td>
                    <td>actions</td>
                </tr>

                <c:forEach var="users" items="${userDao.findAll()}">
                    <tr>
                        <td>${users.getId()}
                        </td>
                        <td>${users.getU_name()}
                        </td>
                        <td>${users.getU_pass()}
                        </td>
                        <td>${users.getU_type()}
                        </td>
                        <td>
                            <form class="btn mt-3" method="post" action="delete">
                                <input type="hidden" name="id" value="${users.getId()}">
                                <button class="btn mt-3" type="submit">delete</button>
                            </form>
                        </td>
                        <td>
                            <form method="post" action="update">
                                <input type="hidden" name="id" value="${users.getId()}">
                                <button class="btn mt-3" type="submit">edit</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <br>
            <a href="create.jsp">create</a>
        </div>
        <div class="text-center fs-6">
            <a href="index.jsp">start page</a>
        </div>
    </div>
</div>
</body>
</html>
