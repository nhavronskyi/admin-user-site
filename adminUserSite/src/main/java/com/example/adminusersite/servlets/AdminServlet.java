package com.example.adminusersite.servlets;

import com.example.adminusersite.dao.UserDao;
import com.example.adminusersite.dao.UserDaoImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class AdminServlet extends HttpServlet {
    private final UserDao userDao = new UserDaoImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.setAttribute("dao", userDao);
            req.getRequestDispatcher("adminPage.jsp").forward(req, resp);
        } catch (ServletException | IOException ex) {
            try {
                req.setAttribute("message", "something went wrong with admin");
                req.getRequestDispatcher("errorPage.jsp").forward(req, resp);
            } catch (ServletException | IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
