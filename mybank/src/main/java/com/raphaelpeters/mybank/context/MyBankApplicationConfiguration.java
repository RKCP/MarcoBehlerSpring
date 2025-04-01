package com.raphaelpeters.mybank.context;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.raphaelpeters.mybank.ApplicationLauncher;
import com.raphaelpeters.mybank.service.TransactionService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@ComponentScan(basePackageClasses = ApplicationLauncher.class)
@PropertySource("classpath:/application.properties")
@Configuration
public class MyBankApplicationConfiguration {

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }
}
