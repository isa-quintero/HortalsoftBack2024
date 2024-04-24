package com.hortalsoft.products.infrastructure.adapter.inbound.controller;

import com.hortalsoft.products.application.dto.ProductDTO;
import com.hortalsoft.products.application.facades.facade.product.CreateProductFacade;
import com.hortalsoft.products.application.facades.facade.product.DeleteProductFacade;
import com.hortalsoft.products.application.facades.facade.product.FindProductFacade;
import com.hortalsoft.products.application.facades.facade.product.ListProductsFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/product")
public class ProductController {

    private final CreateProductFacade facadeCreate;
    private final DeleteProductFacade facadeDelete;
    private final FindProductFacade facadeFind;
    private final ListProductsFacade facadeList;
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    public ProductController(CreateProductFacade facade,DeleteProductFacade facadeDelete,FindProductFacade facadeFind, ListProductsFacade facadeList) {
        this.facadeCreate = facade;
        this.facadeDelete = facadeDelete;
        this.facadeFind = facadeFind;
        this.facadeList = facadeList;
    }
    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO input){
        try{
            facadeCreate.execute(input);
            logger.info("Producto creado");
            return ResponseEntity.ok().build();
        }
        catch (Error e){
            logger.error("Error creando el producto",e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping
    public ResponseEntity<ProductDTO> deleteProduct(@RequestParam (name = "id") long id){
        try{
            ProductDTO product = new ProductDTO(id,"",0);
            logger.info("Producto eliminado");
            facadeDelete.execute(product);
            return ResponseEntity.ok().build();
        }
        catch (Error e){
            logger.error("Error eliminando el producto",e.getMessage());
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @GetMapping
    public ResponseEntity<ProductDTO> findProduct(@RequestParam (name = "id") long id){
        ProductDTO product = new ProductDTO(id,"",0);
        ProductDTO productDTO =facadeFind.execute(product);
        if (productDTO != null){
            logger.info("Producto encontrado");
            //return productDTO.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
            return ResponseEntity.ok().body(productDTO);
        } else{
            logger.error("Producto no encontrado");
            return ResponseEntity.notFound().build();
        }

    }

    @GetMapping("/list")
    public ResponseEntity<List<ProductDTO>> listProducts(){
        try{
            List<ProductDTO> productDTOS = facadeList.execute();
            return new ResponseEntity<>(productDTOS, HttpStatus.OK);
        }
        catch (Error e){
            logger.error("Error obteniendo los productos",e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }
}
