package com.raphaelpeters;

import java.util.UUID;

public record Invoice(String id, String userId, String pdfUrl, Integer amount) {
    public Invoice {
        id = UUID.randomUUID().toString();
    }
}
