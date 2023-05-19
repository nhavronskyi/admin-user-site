package com.example.adminusersite.servlets;


import com.example.adminusersite.dao.UserDao;
import com.example.adminusersite.dao.UserDaoImpl;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;

public class AdminServlet extends HttpServlet {
    @Override
    @SneakyThrows
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        UserDao userDao = new UserDaoImpl();
        req.setAttribute("dao", userDao);
        req.getRequestDispatcher("adminPage.jsp").forward(req, resp);
    }
}
