package com.raphaelpeters;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class MyInvoicesServlet extends HttpServlet {

    private final InvoiceService invoiceService = new InvoiceService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getRequestURI().equalsIgnoreCase("/")) {
            response.setContentType("text/html; charset=UTF-8");
            response.getWriter().print(
                    "<html>\n" +
                            "<body>\n" +
                            "<h1>Hello World</h1>\n" +
                            "<p>Raphael has created a embedded Tomcat, HTML Page!</p>\n" +
                            "</body>\n" +
                            "</html>");
        } else if (request.getRequestURI().equalsIgnoreCase("/invoices")) {
            response.setContentType("application/json; charset=UTF-8");
            response.getWriter().print(invoiceService.create("777", 7070));
        }
    }

//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        if (request.c)
//    }


}