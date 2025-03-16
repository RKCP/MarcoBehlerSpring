package com.raphaelpeters.myfancypdfinvoices.context;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.raphaelpeters.myfancypdfinvoices.service.InvoiceService;
import com.raphaelpeters.myfancypdfinvoices.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyFancyPdfInvoicesApplicationConfiguration {

    @Bean
    public UserService userService() {
        return new UserService();
    }

    @Bean
    public InvoiceService invoiceService(UserService userService) {
        return new InvoiceService(userService);
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }
}
