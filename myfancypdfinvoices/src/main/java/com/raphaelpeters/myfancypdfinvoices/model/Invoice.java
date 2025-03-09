package com.raphaelpeters.myfancypdfinvoices.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.UUID;
@JsonPropertyOrder({"id", "user_id", "pdf_url", "amount"})
public record Invoice(String id,
                      @JsonProperty("user_id") String userId,
                      @JsonProperty("pdf_url") String pdfUrl,
                      Integer amount) {
    public Invoice {
        id = UUID.randomUUID().toString();
    }
}
