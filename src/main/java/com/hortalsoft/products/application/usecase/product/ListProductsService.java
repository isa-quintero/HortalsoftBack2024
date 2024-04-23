package com.hortalsoft.products.application.usecase.product;


import com.hortalsoft.products.domain.domain.Product;
import com.hortalsoft.products.domain.entity.ProductEntity;
import com.hortalsoft.products.domain.port.product.ListProductsUseCase;
import com.hortalsoft.products.domain.repository.ProductRepository;
import com.hortalsoft.products.util.mapper.MapperEntityToDomain;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionSystemException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ListProductsService implements ListProductsUseCase {

    private final ProductRepository productRepository;
    MapperEntityToDomain<ProductEntity,Product> mapperEntityToDomain = new MapperEntityToDomain<>();


    @Autowired
    public ListProductsService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public List<Product> execute(Optional<Product> domain) {
        try{
            List<ProductEntity> resultList = productRepository.findAll();
            List<Product> products = new ArrayList<>();
            resultList.forEach(productEntity -> {
                Product result = mapperEntityToDomain.mapToDomain(productEntity,Product.class);
                products.add(result);
            });
            return products;
        }
        catch(Exception e){
            throw new TransactionSystemException(e.getMessage());
        }
    }
}
