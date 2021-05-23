package com.shalunov.lab9;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/multipleRedirect")
public class MultipleRedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String parameter = "redirect-to";
        resp.sendRedirect(req.getContextPath() + "/redirectTo?param=" + parameter);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String parameter = req.getParameter("url");
        resp.sendRedirect(req.getContextPath() + "/redirectTo?param=" + parameter);
    }
}
