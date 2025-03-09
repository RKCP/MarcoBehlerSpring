package com.raphaelpeters.myfancypdfinvoices.service;

import com.raphaelpeters.myfancypdfinvoices.model.Invoice;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class InvoiceService {

    List<Invoice> invoiceList = new CopyOnWriteArrayList<>();

    public List<Invoice> getInvoiceList() {
        return invoiceList;
    }

    public Invoice create(String userId, Integer amount) {
        // real PDF creation later
        Invoice invoice = new Invoice("",
                userId,
                "http://www.africau.edu/images/default/sample.pdf",
                amount);

        invoiceList.add(invoice);
        return invoice;
    }
}
