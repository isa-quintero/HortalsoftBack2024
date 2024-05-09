package com.hortalsoft.products.domain.port.usecase.product;


import com.hortalsoft.products.domain.domain.Product;
import com.hortalsoft.products.domain.entity.ProductEntity;
import com.hortalsoft.products.domain.port.input.product.FindProductUseCase;
import com.hortalsoft.products.domain.repository.ProductRepository;
import com.hortalsoft.products.domain.mapper.MapperDomainToEntity;
import com.hortalsoft.products.domain.mapper.MapperEntityToDomain;
import com.hortalsoft.products.domain.specification.implementation.ProductExistsSpecification;
import com.hortalsoft.crosscutting.util.ExceptionHortalsoft;
import com.hortalsoft.crosscutting.util.Layers;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class FindProductService implements FindProductUseCase {

    private final ProductRepository productRepository;
    MapperDomainToEntity<Product,ProductEntity> mapperDomainToEntity = new MapperDomainToEntity<>();
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
            ProductExistsSpecification productExistsSpec = new ProductExistsSpecification(entity.getId(), productRepository);
            if (productExistsSpec.isSatisfiedBy(entity)) {
                return mapperEntityToDomain.mapToDomain(resultEntity.get(),Product.class);
            }
            else{
                throw  new ExceptionHortalsoft("Producto no encontrado", 6001, Layers.DOMAIN);
            }

        } catch (ExceptionHortalsoft e) {
            throw e;
        } catch (Exception e) {
            throw new ExceptionHortalsoft(e.getMessage(), 500, Layers.DOMAIN);
        }
    }
}
