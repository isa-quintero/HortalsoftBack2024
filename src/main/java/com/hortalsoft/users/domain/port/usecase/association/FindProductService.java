package com.hortalsoft.users.domain.port.usecase.association;


import com.hortalsoft.crosscutting.util.ExceptionHortalsoft;
import com.hortalsoft.crosscutting.util.Layer;
import com.hortalsoft.products.domain.domain.Product;
import com.hortalsoft.products.domain.entity.ProductEntity;
import com.hortalsoft.products.domain.mapper.MapperDomainToEntity;
import com.hortalsoft.products.domain.mapper.MapperEntityToDomain;
import com.hortalsoft.products.domain.repository.ProductRepository;
import com.hortalsoft.products.domain.specification.implementation.product.ProductExistsByIdSpec;
import com.hortalsoft.users.domain.port.input.product.FindProductUseCase;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@Transactional
public class FindProductService implements FindProductUseCase {

    private static final Layer layer = Layer.DOMAIN;
    private final ProductRepository productRepository;
    MapperDomainToEntity<Product, ProductEntity> mapperDomainToEntity = new MapperDomainToEntity<>();
    MapperEntityToDomain<ProductEntity, Product> mapperEntityToDomain = new MapperEntityToDomain<>();


    @Autowired
    public FindProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product execute(Product domain) {
        try {
            ProductEntity entity = mapperDomainToEntity.mapToEntity(domain, ProductEntity.class);
            ProductExistsByIdSpec productExistsSpec = new ProductExistsByIdSpec(productRepository);
            if (productExistsSpec.isSatisfiedBy(entity)) {
                Optional<ProductEntity> productEntity =productRepository.findById(entity.getId());
                return mapperEntityToDomain.mapToDomain(productEntity.get(), Product.class);
            } else {
                throw new ExceptionHortalsoft("Producto no encontrado", 6001, layer);
            }

        } catch (ExceptionHortalsoft exceptionHortalsoft) {
            throw exceptionHortalsoft;
        } catch (Exception exception) {
            throw new ExceptionHortalsoft("Ha ocurrido un error inesperado buscando el producto", 500, layer, exception);
        }
    }
}
