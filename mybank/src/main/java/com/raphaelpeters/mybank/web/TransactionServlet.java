package com.raphaelpeters.mybank.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.raphaelpeters.mybank.model.Transaction;
import com.raphaelpeters.mybank.service.TransactionService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class TransactionServlet extends HttpServlet {

    private final TransactionService transactionService = new TransactionService();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        objectMapper.findAndRegisterModules();
        if (request.getRequestURI().equalsIgnoreCase("/{id}")) { // INVALID
            response.setContentType("application/json; charset=UTF-8");

            String id = request.getParameter("id");
            try {
                response.getWriter().print(objectMapper.writeValueAsString(
                        transactionService.getTransaction(id)
                ));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else if (request.getRequestURI().equalsIgnoreCase("/getAllTransactions")) {
            response.setContentType("application/json; charset=UTF-8");

            try {
                response.getWriter().print(objectMapper.writeValueAsString(
                        transactionService.getAllTransactions()
                ));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        objectMapper.findAndRegisterModules();
        if (request.getRequestURI().equalsIgnoreCase("/createTransaction")) {
            response.setContentType("application/json; charset=UTF-8");

            String id = request.getParameter("id");
            int amount = Integer.parseInt(request.getParameter("amount"));
            String timestamp = request.getParameter("timestamp");
            String reference = request.getParameter("reference");
            Transaction transaction = transactionService.createTransaction(id, amount, timestamp, reference);
            try {
                response.getWriter().print(objectMapper.writeValueAsString(
                        transaction
                ));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }


}
