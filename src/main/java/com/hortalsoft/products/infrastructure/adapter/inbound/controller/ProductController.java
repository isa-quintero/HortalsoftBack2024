package com.hortalsoft.products.infrastructure.adapter.inbound.controller;

import com.hortalsoft.products.application.dto.ProductDTO;
import com.hortalsoft.products.application.facades.facade.product.*;
import com.hortalsoft.crosscutting.util.ExceptionHandlingAspect;
import com.hortalsoft.crosscutting.util.ExceptionHortalsoft;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/inventory")
public class ProductController {

    private final CreateProductFacade facadeCreate;
    private final DeleteProductFacade facadeDelete;
    private final FindProductFacade facadeFind;
    private final ListProductsFacade facadeList;
    private final ModifyProductFacade facadeModify;
    private final ExceptionHandlingAspect exceptionHandlingAspect;
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    public ProductController(CreateProductFacade facadeCreate, DeleteProductFacade facadeDelete, FindProductFacade facadeFind, ListProductsFacade facadeList, ModifyProductFacade facadeModify, ExceptionHandlingAspect exceptionHandlingAspect) {
        this.facadeCreate = facadeCreate;
        this.facadeDelete = facadeDelete;
        this.facadeFind = facadeFind;
        this.facadeList = facadeList;
        this.facadeModify = facadeModify;
        this.exceptionHandlingAspect = exceptionHandlingAspect;
    }
    @PostMapping("/products")
    public ResponseEntity<Object> createProduct(@RequestBody ProductDTO input){
        try{
            facadeCreate.execute(input);
            logger.info("Producto creado");
            return ResponseEntity.ok().build();
        }
        catch (Exception e){
            return exceptionHandlingAspect.exceptionsInfrastructure(e);
        }
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable (name = "id") int id){
        try{
            ProductDTO product = new ProductDTO(id,"",0);
            facadeDelete.execute(product);
            logger.info("Producto eliminado");
            return ResponseEntity.ok().build();
        }
        catch (Exception e){
            return exceptionHandlingAspect.exceptionsInfrastructure(e);
        }
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Object> findProduct(@PathVariable (name = "id") int id){
        try {
            ProductDTO product = new ProductDTO(id, "",0);
            ProductDTO productDTO = facadeFind.execute(product);
            logger.info("Producto encontrado");
            return ResponseEntity.ok().body(productDTO);
        }
        catch (ExceptionHortalsoft e){
            return exceptionHandlingAspect.exceptionsInfrastructure(e);
        }

    }

    @GetMapping("/products")
    public ResponseEntity<Object> listProducts(){
        try{
            List<ProductDTO> productDTOS = facadeList.execute();
            return new ResponseEntity<>(productDTOS, HttpStatus.OK);
        }
        catch (ExceptionHortalsoft e){
            return exceptionHandlingAspect.exceptionsInfrastructure(e);
        }
    }
    @PutMapping("/products")
    public ResponseEntity<Object> updateProduct(@RequestBody ProductDTO input){
        try{
            facadeModify.execute(input);
            logger.info("Producto modificado");
            return ResponseEntity.ok().build();
        }
        catch (ExceptionHortalsoft e){
            return exceptionHandlingAspect.exceptionsInfrastructure(e);
        }
    }
}
