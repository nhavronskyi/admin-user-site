package com.example.adminusersite.servlets.crud;

import com.example.adminusersite.dao.UserDao;
import com.example.adminusersite.dao.UserDaoImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/update")
public class UpdateUserServlet extends HttpServlet {
    private final UserDao userDao = new UserDaoImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            if (req.getParameter("login") != null) {
                System.out.println(req.getParameter("id"));
                userDao.updateUser(req.getParameter("login"), req.getParameter("password"), Integer.parseInt(req.getParameter("id")));
                req.getRequestDispatcher("sign-in").forward(req, resp);
            } else {
                System.out.println(req.getParameter("id"));
                req.setAttribute("id", req.getParameter("id"));
                req.getRequestDispatcher("update.jsp").forward(req, resp);
            }
        } catch (ServletException | IOException e) {
            try {
                req.setAttribute("message", "something went wrong");
                req.getRequestDispatcher("errorPage.jsp").forward(req, resp);
            } catch (ServletException | IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
