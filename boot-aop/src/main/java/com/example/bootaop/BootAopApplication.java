package com.example.bootaop;

import com.example.bootaop.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BootAopApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context=SpringApplication.run(BootAopApplication.class, args);
    }

}
