package com.example.adminusersite.filter;

import com.example.adminusersite.dao.UserDao;
import com.example.adminusersite.dao.UserDaoImpl;
import com.example.adminusersite.user.User;
import jakarta.servlet.*;

import java.io.IOException;

public class AuthenticationFilter implements Filter {
    private final UserDao userDao = new UserDaoImpl();

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) {
        User user = userDao.findUser(servletRequest.getParameter("login"), servletRequest.getParameter("password"));

        try {
            if (user.getU_name() == null) {
                servletRequest.setAttribute("message", servletRequest.getParameter("login") + " doesnt exist");
                servletRequest.getRequestDispatcher("errorPage.jsp").forward(servletRequest, servletResponse);
            } else {
                if (user.getU_type().equals("user")) {
                    servletRequest.setAttribute("user", user);
                    servletRequest.getRequestDispatcher("userPage.jsp").forward(servletRequest, servletResponse);
                } else if (user.getU_type().equals("admin")) {
                    filterChain.doFilter(servletRequest, servletResponse);
                }
            }
        } catch (Exception e) {
            try {
                servletRequest.setAttribute("message", "something went wrong");
                servletRequest.getRequestDispatcher("errorPage.jsp").forward(servletRequest, servletResponse);
            } catch (ServletException | IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
