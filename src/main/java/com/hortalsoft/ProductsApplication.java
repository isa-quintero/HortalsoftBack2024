package com.hortalsoft;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductsApplication {
    private static final Logger logger = LoggerFactory.getLogger(ProductsApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(ProductsApplication.class, args);
    }

}