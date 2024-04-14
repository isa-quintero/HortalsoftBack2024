package com.hortalsoft.products.application.service.usecase.product;


import com.hortalsoft.products.domain.domain.Product;
import com.hortalsoft.products.domain.entity.ProductEntity;
import com.hortalsoft.products.domain.port.product.CreateProductUseCase;
import com.hortalsoft.products.domain.port.product.DeleteProductUseCase;
import com.hortalsoft.products.domain.repository.ProductRepository;
import com.hortalsoft.products.util.mapper.MapperDomainToEntity;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class DeleteProductService implements DeleteProductUseCase {

    private final ProductRepository productRepository;
    MapperDomainToEntity<Product,ProductEntity> mapperDomainToEntity = new MapperDomainToEntity();


    @Autowired
    public DeleteProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;

    }

    @Override
    public void execute(Product domain) {
        try{
            Optional<ProductEntity> findbyId = productRepository.findById(domain.getId());
            if(findbyId.get() != null){
                productRepository.delete(findbyId.get());
            }
            else{
                System.out.println("El producto no existe");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
