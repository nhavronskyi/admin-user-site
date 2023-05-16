package com.example.adminusersite.servlets;


import com.example.adminusersite.dao.UserDao;
import com.example.adminusersite.dao.UserDaoImpl;
import com.example.adminusersite.user.User;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;

import java.util.stream.Collectors;

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

        resp.setContentType("text/html");
        var writer = resp.getWriter();

        writer.println("<html>\n" +
                "<head>\n" +
                "    <title>admin user site</title>\n" +
                "</head>\n" +
                "<body>");

        UserDao userDao = new UserDaoImpl();
        User user = userDao.findUser(uname, upass);

        if (user.getU_name() == null) {
            writer.println(uname + " doesnt exist");
        } else {
            if (user.getU_type().equals("user")) {
                writer.println(user);
            } else if (user.getU_type().equals("admin")) {
                writer.println(userDao.findAll().stream()
                        .map(x -> x.getId() + "     " + x.getU_name() + "       " + x.getU_type())
                        .collect(Collectors.joining("</br>")));

                writer.println("</br>---------------------------------");
                writer.println("</br><a href=\"create.jsp\">create</a>");
                writer.println("</br><a href=\"delete.jsp\">delete</a>");
                writer.println("</br><a href=\"update.jsp\">update</a></br>");
            }
        }

        writer.println("</br><a href=\"index.jsp\">logout</a>");

        writer.println("</body>\n" +
                "</html>");
        writer.flush();


    }
}
