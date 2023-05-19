package com.example.adminusersite.servlets.crud;

import com.example.adminusersite.dao.UserDaoImpl;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;

@WebServlet("/update")
public class UpdateUserServlet extends HttpServlet {

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        if (req.getParameter("login") != null) {
            System.out.println(req.getParameter("id"));
            new UserDaoImpl().updateUser(req.getParameter("login"), req.getParameter("password"), Integer.parseInt(req.getParameter("id")));
            req.getRequestDispatcher("sign-in").forward(req, resp);
        } else {
            System.out.println(req.getParameter("id"));
            req.setAttribute("id", req.getParameter("id"));
            req.getRequestDispatcher("update.jsp").forward(req, resp);
        }
    }
}
