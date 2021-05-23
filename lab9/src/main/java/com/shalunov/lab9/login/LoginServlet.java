package com.shalunov.lab9.login;

import com.shalunov.lab9.login.dao.UserDao;
import com.shalunov.lab9.login.dao.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private UserDao userDao;

    @Override
    public void init() throws ServletException {
        super.init();
        userDao = new UserDaoImpl();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = userDao.read(username);
        Cookie cookie = new Cookie("username", username);
        response.addCookie(cookie);
        try (PrintWriter writer = response.getWriter()) {
            if (user != null && user.getPassword().equals(password)) {
                HttpSession session = request.getSession();
                session.setAttribute("username", user.getUsername());
                session.setAttribute("role", user.getRole());
                getServletContext().getRequestDispatcher("/successful-login.jsp").forward(request, response);
            } else {
                getServletContext().getRequestDispatcher("/invalid-login.jsp").forward(request, response);
            }
        }

    }
}
