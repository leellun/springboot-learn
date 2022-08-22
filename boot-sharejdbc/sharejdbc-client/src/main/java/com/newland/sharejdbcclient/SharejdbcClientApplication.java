package com.newland.sharejdbcclient;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.newland.sharejdbcclient.mapper")
public class SharejdbcClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(SharejdbcClientApplication.class, args);
    }

}
