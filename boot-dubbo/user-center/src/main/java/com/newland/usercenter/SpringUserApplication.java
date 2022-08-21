package com.newland.usercenter;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@EnableDubbo
public class SpringUserApplication {
    public static void main(String[] args){
        SpringApplication.run(SpringUserApplication.class,args);
    }
}
