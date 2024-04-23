package com.hortalsoft.products.application.usecase.product;


import com.hortalsoft.products.domain.domain.Product;
import com.hortalsoft.products.domain.entity.ProductEntity;
import com.hortalsoft.products.domain.port.product.CreateProductUseCase;
import com.hortalsoft.products.domain.repository.ProductRepository;
import com.hortalsoft.products.util.mapper.MapperDomainToEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionSystemException;


@Service
public class CreateProductService implements CreateProductUseCase {

    private final ProductRepository productRepository;
    MapperDomainToEntity<Product,ProductEntity> mapperDomainToEntity = new MapperDomainToEntity();


    @Autowired
    public CreateProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;

    }

    @Override
    public void execute(Product domain) {
        try{
            ProductEntity entity =  mapperDomainToEntity.mapToEntity(domain,ProductEntity.class);
            productRepository.save(entity);
        }
        catch(Exception e){
            throw new TransactionSystemException(e.getMessage());
        }
    }
}
