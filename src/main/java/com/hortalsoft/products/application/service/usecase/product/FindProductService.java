package com.hortalsoft.products.application.service.usecase.product;


import com.hortalsoft.products.domain.domain.Product;
import com.hortalsoft.products.domain.entity.ProductEntity;
import com.hortalsoft.products.domain.port.product.CreateProductUseCase;
import com.hortalsoft.products.domain.port.product.FindProductUseCase;
import com.hortalsoft.products.domain.repository.ProductRepository;
import com.hortalsoft.products.util.mapper.MapperDomainToEntity;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class FindProductService implements FindProductUseCase {

    private final ProductRepository productRepository;
    MapperDomainToEntity<Product,ProductEntity> mapperDomainToEntity = new MapperDomainToEntity();


    @Autowired
    public FindProductService(ProductRepository productRepository) {
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
            }

        }
        catch(Exception e){
            e.printStackTrace();
        }return null;
    }
}
