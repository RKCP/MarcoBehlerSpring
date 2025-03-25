package com.raphaelpeters.myfancypdfinvoices.context;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.raphaelpeters.myfancypdfinvoices.ApplicationLauncher;
import com.raphaelpeters.myfancypdfinvoices.service.InvoiceService;
import com.raphaelpeters.myfancypdfinvoices.service.UserService;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;

@ComponentScan(basePackageClasses = ApplicationLauncher.class)
// Need to add this to force scanning of @Component (beans), as it's not done by default
// basePackageClasses will tell Spring to scan package that ApplicationLauncher.class is in, and all sub-packages
// @SpringBootApplication annotation, which every Spring Boot application needs, is a meta annotation which includes the @ComponentScan annotation.
// At its core, a meta-annotation is an annotation that annotates another annotation. It acts as a wrapper, allowing for the bundling of multiple annotations under one umbrella. You can custom-make these.
@Configuration
@PropertySource("classpath:/application.properties")
public class MyFancyPdfInvoicesApplicationConfiguration {

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }
}
