package com.hortalsoft.products.application.usecase.product;


import com.hortalsoft.products.domain.domain.Product;
import com.hortalsoft.products.domain.entity.ProductEntity;
import com.hortalsoft.products.domain.port.product.DeleteProductUseCase;
import com.hortalsoft.products.domain.repository.ProductRepository;
import com.hortalsoft.products.infrastructure.adapter.inbound.controller.ProductController;
import com.hortalsoft.products.util.mapper.MapperDomainToEntity;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionSystemException;

import java.util.Optional;

@Service
@Transactional
public class DeleteProductService implements DeleteProductUseCase {

    private final ProductRepository productRepository;
    MapperDomainToEntity<Product,ProductEntity> mapperDomainToEntity = new MapperDomainToEntity();
    private static final Logger logger = LoggerFactory.getLogger(DeleteProductService.class);



    @Autowired
    public DeleteProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;

    }

    @Override
    public void execute(Product domain) {
        try{
            if(productRepository.existsById(domain.getId())){
                productRepository.deleteById(domain.getId());
            }
            else{
                logger.error("El producto no existe");
            }
        }
        catch(Exception e){
            throw new TransactionSystemException(e.getMessage());
        }
    }
}
