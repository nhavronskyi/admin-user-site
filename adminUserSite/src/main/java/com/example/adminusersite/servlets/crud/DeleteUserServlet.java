package com.example.adminusersite.servlets.crud;

import com.example.adminusersite.dao.UserDao;
import com.example.adminusersite.dao.UserDaoImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/delete")
public class DeleteUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        UserDao userDao = new UserDaoImpl();
        userDao.deleteUser(Integer.parseInt(req.getParameter("id")));

        try {
            req.getRequestDispatcher("sign-in").forward(req, resp);
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
