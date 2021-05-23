package com.shalunov.lab9;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Enumeration;

@WebServlet("/time")
public class GetTimeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        try (PrintWriter writer = response.getWriter()) {
            writer.printf("current time: %s%n", DateTimeFormatter.ofPattern("HH:mm").format(LocalTime.now()));
            writer.print(getRequestInfo(request, response));
            writer.print(getHeaderInfo(request));
        }
    }

    private String getRequestInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        return String.format("<p>method: %s</p>", request.getMethod()) +
                String.format("<p>url: %s</p>", request.getRequestURL()) +
                String.format("<p>protocol: %s</p>", request.getProtocol()) +
                String.format("<p>client ip: %s</p>", request.getRemoteAddr()) +
                String.format("<p>client name: %s</p>", request.getRemoteHost()) +
                String.format("<p>port: %d</p>", request.getRemotePort()) +
                String.format("<p>server: %s:%d</p>", request.getServerName(), request.getServerPort()) +
                String.format("<p>path: %s</p>", request.getContextPath()) +
                String.format("<p>scheme: %s</p>", request.getScheme());
    }

    private String getHeaderInfo(HttpServletRequest request) throws IOException {
        StringBuilder result = new StringBuilder();
        Enumeration<String> e = request.getHeaderNames();

        while (e.hasMoreElements()) {
            String name = e.nextElement();
            String value = request.getHeader(name);
            result.append(String.format("<p>%s = %s</p>", name, value));
        }

        return result.toString();
    }

}
