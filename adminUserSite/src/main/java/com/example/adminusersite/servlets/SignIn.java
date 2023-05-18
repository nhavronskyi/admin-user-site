package com.example.adminusersite.servlets;


import com.example.adminusersite.dao.UserDao;
import com.example.adminusersite.dao.UserDaoImpl;
import com.example.adminusersite.user.User;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;

/**
 * <h1>проста адмінка, яка буде мати наступний функціонал</h1>
 * <ol>
 * <li> + Сторінка звичайного юзера - має показуватись інформація тільки про активного юзера.</li>
 * <li> + Сторінка адміна - має бути таблиця зі списком усіх юзерів. Адмін може змінити, видалити або додати юзера.</li>
 * <li> + Юзер немає доступа на сторінку адміна. Адмін не має доступа на сторінку юзера.</li>
 * <li> + Треба додати можливість реєєструватись з ролью юзера. </li>
 * <li> + Має бути кнопка logout.</li>
 * </ol>
 * <h2>По технологіям.</h2>
 * <ul>
 * <li>Database - whatever you like</li>
 * <li>JBDC</li>
 * <li>Servlets</li>
 * <li>Tomcat 10</li>
 * <li>JSP/FTL/HTML - що захочете.</li>
 * </ul>
 */

@WebServlet(name = "sign-in", value = "/sign-in")
public class SignIn extends HttpServlet {

    @Override
    @SneakyThrows
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String uname = req.getParameter("login");
        String upass = req.getParameter("password");

        UserDao userDao = new UserDaoImpl();
        User user = userDao.findUser(uname, upass);

        if (user.getU_name() == null) {
            req.setAttribute("message", uname + " doesnt exist");
            req.getRequestDispatcher("errorPage.jsp").forward(req, resp);
        } else {
            if (user.getU_type().equals("user")) {
                req.setAttribute("user", user);
                req.getRequestDispatcher("userPage.jsp").forward(req, resp);
            } else if (user.getU_type().equals("admin")) {
                req.setAttribute("dao", userDao);
                req.getRequestDispatcher("adminPage.jsp").forward(req, resp);
            }
        }
    }
}
