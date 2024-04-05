package com.hortalSoft.transactions.backend;

import com.hortalSoft.products.backend.ProductsBackendApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TransactionsBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductsBackendApplication.class, args);
	}

}
