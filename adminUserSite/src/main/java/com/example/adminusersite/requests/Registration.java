package com.example.adminusersite.requests;

import com.example.adminusersite.dao.UserDao;
import com.example.adminusersite.dao.UserDaoImpl;
import com.example.adminusersite.user.User;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;

@WebServlet("/registration")
public class Registration extends HttpServlet {
    @Override
    @SneakyThrows
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String uname = req.getParameter("login");
        String upass = req.getParameter("password");
        UserDao userDao = new UserDaoImpl();

        User user = userDao.findUser(uname, upass);
        var writer = resp.getWriter();

        if (uname.equals(user.getU_name())) {
            writer.println("this user already exist");
        } else {
            userDao.createUser(uname, upass);
            writer.println("account is created");
        }
        writer.flush();
    }
}
