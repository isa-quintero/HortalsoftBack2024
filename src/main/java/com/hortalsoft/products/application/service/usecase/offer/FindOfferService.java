package com.hortalsoft.products.application.service.usecase.offer;


import com.hortalsoft.products.domain.domain.Product;
import com.hortalsoft.products.domain.entity.ProductEntity;
import com.hortalsoft.products.domain.port.product.FindProductUseCase;
import com.hortalsoft.products.domain.repository.ProductRepository;
import com.hortalsoft.products.util.mapper.MapperDomainToEntity;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionSystemException;

import java.util.Optional;

@Service
@Transactional
public class FindOfferService implements FindProductUseCase {

    private final ProductRepository productRepository;
    MapperDomainToEntity<Product,ProductEntity> mapperDomainToEntity = new MapperDomainToEntity();


    @Autowired
    public FindOfferService(ProductRepository productRepository) {
        this.productRepository = productRepository;

    }


    @Override
    public ProductEntity execute(Product domain) {
        try{
            if(productRepository.existsById(domain.getId())){
                ProductEntity entity =  mapperDomainToEntity.mapToEntity(domain,ProductEntity.class);
                Optional<ProductEntity> result =  productRepository.findById(entity.getId());
                return result.orElse(null);
            }
            else{
                System.out.println("El producto no existe");
                return null;
            }

        }
        catch(Exception e){
            throw new TransactionSystemException(e.getMessage());

        }

    }
}
