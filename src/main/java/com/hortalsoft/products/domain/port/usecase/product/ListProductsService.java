package com.hortalsoft.products.domain.port.usecase.product;


import com.hortalsoft.products.domain.domain.Product;
import com.hortalsoft.products.domain.entity.ProductEntity;
import com.hortalsoft.products.domain.port.input.product.ListProductsUseCase;
import com.hortalsoft.products.domain.repository.ProductRepository;
import com.hortalsoft.products.domain.mapper.MapperEntityToDomain;
import com.hortalsoft.products.util.ExceptionHortalsoft;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<Product> execute() {
        try{
            if (productRepository.count() != 0) {
                List<ProductEntity> resultList = productRepository.findAll();
                return mapperEntityToDomain.mapToDomainList(resultList,Product.class);
            }
            else{
                throw  new ExceptionHortalsoft("No hay productos para mostrar", 6001);
            }

        }
        catch(Exception e){
            throw e;
        }
    }
}
