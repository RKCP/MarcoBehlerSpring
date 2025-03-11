package com.raphaelpeters.myfancypdfinvoices.service;

import com.raphaelpeters.myfancypdfinvoices.model.Invoice;
import com.raphaelpeters.myfancypdfinvoices.model.User;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class InvoiceService {

    List<Invoice> invoiceList = new CopyOnWriteArrayList<>();

    public List<Invoice> getInvoiceList() {
        return invoiceList;
    }

    public Invoice create(String userId, Integer amount) {
        User user = new UserService().findById(userId);
        if (user == null) {
            throw new IllegalStateException();
        }

        // real PDF creation later
        Invoice invoice = new Invoice(userId,
                "http://www.africau.edu/images/default/sample.pdf",
                amount);

        invoiceList.add(invoice);
        return invoice;
    }
}
