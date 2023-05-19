package com.example.adminusersite.servlets.crud;

import com.example.adminusersite.dao.UserDao;
import com.example.adminusersite.dao.UserDaoImpl;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;


@WebServlet("/create")
public class CreateUserByAdminServlet extends HttpServlet {
    @Override
    @SneakyThrows
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String uname = req.getParameter("login");
        String upass = req.getParameter("password");
        UserDao userDao = new UserDaoImpl();

        userDao.createUser(uname, upass);
        req.getRequestDispatcher("sign-in").forward(req, resp);
    }
}
