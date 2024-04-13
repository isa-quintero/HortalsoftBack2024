package com.hortalsoft.products.infrastructure.adapter.inbound.controller;

import com.hortalsoft.products.application.dto.ProductDTO;
import com.hortalsoft.products.application.service.facade.product.CreateProductFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final CreateProductFacade facade;

    public ProductController(CreateProductFacade facade) {
        this.facade = facade;
    }
    @PostMapping
    public ResponseEntity<?> post(@RequestBody ProductDTO input){
        try{
            return ok(facade.execute(input));
        }
        catch (Error e){
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }
}
