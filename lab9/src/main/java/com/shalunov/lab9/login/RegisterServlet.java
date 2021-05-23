package com.shalunov.lab9.login;

import com.shalunov.lab9.login.dao.UserDao;
import com.shalunov.lab9.login.dao.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    UserDao userDao;

    @Override
    public void init() throws ServletException {
        super.init();
        userDao = new UserDaoImpl();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User(request.getParameter("username"), request.getParameter("password"), "user");
        if (userDao.create(user)) {
            getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
        } else {
            response.getWriter().println("registration error");
        }
    }
}
