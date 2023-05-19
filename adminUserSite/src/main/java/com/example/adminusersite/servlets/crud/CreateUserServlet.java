package com.example.adminusersite.servlets.crud;

import com.example.adminusersite.dao.UserDao;
import com.example.adminusersite.dao.UserDaoImpl;
import com.example.adminusersite.user.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/register")
public class CreateUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String username = req.getParameter("login");
        String password = req.getParameter("password");
        UserDao userDao = new UserDaoImpl();

        User user = userDao.findUser(username, password);

        if (username.equals(user.getU_name())) {
            req.setAttribute("message", "this user already exist");
        } else {
            userDao.createUser(username, password);
            req.setAttribute("message", "user is created");
        }

        try {
            req.getRequestDispatcher("errorPage.jsp").forward(req, resp);
        } catch (ServletException | IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
