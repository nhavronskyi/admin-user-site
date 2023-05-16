package com.example.adminusersite.requests;

import com.example.adminusersite.dao.UserDaoImpl;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/update")
public class Update extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        new UserDaoImpl().updateUser(req.getParameter("login"), req.getParameter("password"), Integer.parseInt(req.getParameter("id")));
    }
}
