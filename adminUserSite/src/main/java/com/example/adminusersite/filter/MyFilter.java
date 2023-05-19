package com.example.adminusersite.filter;

import com.example.adminusersite.dao.UserDao;
import com.example.adminusersite.dao.UserDaoImpl;
import com.example.adminusersite.user.User;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import lombok.SneakyThrows;

public class MyFilter implements Filter {
    @SneakyThrows
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) {
        String uname = servletRequest.getParameter("login");
        String upass = servletRequest.getParameter("password");

        UserDao userDao = new UserDaoImpl();
        User user = userDao.findUser(uname, upass);

        if (user.getU_name() == null) {
            servletRequest.setAttribute("message", uname + " doesnt exist");
            servletRequest.getRequestDispatcher("errorPage.jsp").forward(servletRequest, servletResponse);
        } else {
            if (user.getU_type().equals("user")) {
                servletRequest.setAttribute("user", user);
                servletRequest.getRequestDispatcher("userPage.jsp").forward(servletRequest, servletResponse);
            } else if (user.getU_type().equals("admin")) {
                filterChain.doFilter(servletRequest, servletResponse);
            }
        }
    }
}
