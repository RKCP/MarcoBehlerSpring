package com.raphaelpeters.mybank.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record Transaction(String id, int amount, @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")LocalDateTime timestamp, String reference, String slogan) {
}
