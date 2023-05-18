package com.example.adminusersite.servlets.crud;

import com.example.adminusersite.dao.UserDao;
import com.example.adminusersite.dao.UserDaoImpl;
import com.example.adminusersite.user.User;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;

@WebServlet("/register")
public class CreateUserServlet extends HttpServlet {
    @Override
    @SneakyThrows
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String uname = req.getParameter("login");
        String upass = req.getParameter("password");
        UserDao userDao = new UserDaoImpl();

        User user = userDao.findUser(uname, upass);

        if (uname.equals(user.getU_name())) {
            req.setAttribute("message", "this user already exist");
        } else {
            userDao.createUser(uname, upass);
            req.setAttribute("message", "user is created");
        }
        req.getRequestDispatcher("errorPage.jsp").forward(req, resp);
    }
}
