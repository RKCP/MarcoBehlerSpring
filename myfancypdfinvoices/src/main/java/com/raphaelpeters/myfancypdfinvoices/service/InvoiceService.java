package com.raphaelpeters.myfancypdfinvoices.service;

import com.raphaelpeters.myfancypdfinvoices.model.Invoice;
import com.raphaelpeters.myfancypdfinvoices.model.User;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class InvoiceService {

    List<Invoice> invoiceList = new CopyOnWriteArrayList<>();
    private final UserService userService;
    private final String cdnUrl;

    public InvoiceService(UserService userService, @Value("${cdn.url}") String cdnUrl) {
        this.userService = userService;
        this.cdnUrl = cdnUrl;
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
                cdnUrl + "/images/default/sample.pdf",
                amount);

        invoiceList.add(invoice);
        return invoice;
    }

    @PostConstruct
    public void init() {
        System.out.println("Fetching PDF Tempalte from S3...");
        // TODO download from s3 and save locally
    }

    @PreDestroy
    public void shutdown() {
        System.out.println("Deleting downloaded templates...");
        // TODO actual deletion of PDFs
    }
}
