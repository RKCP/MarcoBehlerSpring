package com.raphaelpeters.myfancypdfinvoices.service;

import com.raphaelpeters.myfancypdfinvoices.model.Invoice;
import com.raphaelpeters.myfancypdfinvoices.model.User;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
@Component
public class InvoiceService {

    @PostConstruct
    public void init() {
        System.out.println("Fetching PDF Tempalte from S3...");
        // TODO download from s3 and save locally
    }

    List<Invoice> invoiceList = new CopyOnWriteArrayList<>();
    private final UserService userService;

    public InvoiceService(UserService userService) {
        this.userService = userService;
    }

    public List<Invoice> getInvoiceList() {
        return invoiceList;
    }

    public Invoice create(String userId, Integer amount) {
        User user = userService.findById(userId);
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

    @PreDestroy
    public void shutdown() {
        System.out.println("Deleting downloaded templates...");
        // TODO actual deletion of PDFs
    }
}
