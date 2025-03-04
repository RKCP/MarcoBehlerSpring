package com.raphaelpeters;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class MyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html; charset=UTF-8");
        response.getWriter().print(
                "<html>\n" +
                "<body>\n" +
                "<h1>Hello World</h1>\n" +
                "<p>Raphael has created a embedded Tomcat, HTML Page!</p>\n" +
                "</body>\n" +
                "</html>");
    }


}