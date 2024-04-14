package com.hortalsoft.products.infrastructure.adapter.inbound.controller;

import com.hortalsoft.products.application.dto.ProductDTO;
import com.hortalsoft.products.application.service.facade.product.CreateProductFacade;
import com.hortalsoft.products.application.service.facade.product.DeleteProductFacade;
import com.hortalsoft.products.application.service.facade.product.FindProductFacade;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/products")
public class ProductController {

    private final CreateProductFacade facadeCreate;
    private final DeleteProductFacade facadeDelete;
    private final FindProductFacade facadeFind;

    public ProductController(CreateProductFacade facade,DeleteProductFacade facadeDelete,FindProductFacade facadeFind) {
        this.facadeCreate = facade;
        this.facadeDelete = facadeDelete;
        this.facadeFind = facadeFind;
    }
    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO input){
        try{
            facadeCreate.execute(input);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Error e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @DeleteMapping
    public ResponseEntity<ProductDTO> deleteProduct(@RequestParam (name = "id") long id){
        try{
            ProductDTO product = new ProductDTO();
            product.setId(id);
            product.setName("");
            product.setCodeSubcategory(0);
            facadeDelete.execute(product);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Error e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @GetMapping
    public ResponseEntity<ProductDTO> findProduct(@RequestParam (name = "id") long id){
        try{
            ProductDTO product = new ProductDTO();
            product.setId(id);
            product.setName("");
            product.setCodeSubcategory(0);
            facadeFind.execute(product);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Error e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }
}
