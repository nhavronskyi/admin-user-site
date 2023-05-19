package com.example.adminusersite.servlets.crud;

import com.example.adminusersite.dao.UserDao;
import com.example.adminusersite.dao.UserDaoImpl;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;

@WebServlet("/delete")
public class DeleteUserServlet extends HttpServlet {
    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        UserDao userDao = new UserDaoImpl();
        userDao.deleteUser(Integer.parseInt(req.getParameter("id")));

        req.getRequestDispatcher("sign-in").forward(req, resp);
    }
}
