package com.hortalsoft.products.application.usecase.product;


import com.hortalsoft.products.domain.domain.Product;
import com.hortalsoft.products.domain.entity.ProductEntity;
import com.hortalsoft.products.domain.port.product.FindProductUseCase;
import com.hortalsoft.products.domain.repository.ProductRepository;
import com.hortalsoft.products.util.mapper.MapperDomainToEntity;
import com.hortalsoft.products.util.mapper.MapperEntityToDomain;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionSystemException;

import java.util.Optional;

@Service
@Transactional
public class FindProductService implements FindProductUseCase {

    private final ProductRepository productRepository;
    MapperDomainToEntity<Product,ProductEntity> mapperDomainToEntity = new MapperDomainToEntity();
    MapperEntityToDomain<ProductEntity,Product> mapperEntityToDomain = new MapperEntityToDomain<>();

    @Autowired
    public FindProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;

    }


    @Override
    public Product execute(Product domain) {
        try{
            ProductEntity entity =  mapperDomainToEntity.mapToEntity(domain,ProductEntity.class);
            Optional<ProductEntity> resultEntity= productRepository.findById(entity.getId());
            if (resultEntity.isPresent()) {
                Product result = mapperEntityToDomain.mapToDomain(resultEntity.get(),Product.class);
                return result;
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
