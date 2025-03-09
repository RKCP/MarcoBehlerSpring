package com.raphaelpeters;

public class InvoiceService {

    public Invoice create(String userId, Integer amount) {
        // real PDF creation later
        return new Invoice("", userId, "http://www.africau.edu/images/default/sample.pdf", amount);
    }
}
