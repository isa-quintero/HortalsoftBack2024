package com.hortalsoft.users.domain.port.usecase.customer;


import com.hortalsoft.crosscutting.util.ExceptionHortalsoft;
import com.hortalsoft.crosscutting.util.Layer;
import com.hortalsoft.products.domain.domain.Product;
import com.hortalsoft.products.domain.entity.ProductEntity;
import com.hortalsoft.products.domain.mapper.MapperDomainToEntity;
import com.hortalsoft.products.domain.repository.ProductRepository;
import com.hortalsoft.products.domain.specification.implementation.product.UniqueProductNameSpec;
import com.hortalsoft.users.domain.port.input.product.CreateProductUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CreateProductService implements CreateProductUseCase {

    private static final Layer layer = Layer.DOMAIN;
    private final ProductRepository productRepository;
    MapperDomainToEntity<Product, ProductEntity> mapperDomainToEntity = new MapperDomainToEntity<>();


    @Autowired
    public CreateProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void execute(Product domain) {
        try {
            UniqueProductNameSpec uniqueProductNameSpec = new UniqueProductNameSpec(productRepository);
            ProductEntity entity = mapperDomainToEntity.mapToEntity(domain, ProductEntity.class);
            if (uniqueProductNameSpec.isSatisfiedBy(entity)) {
                productRepository.save(entity);
            } else {
                throw new ExceptionHortalsoft("El producto ya existe", 5001, layer);
            }
        } catch (ExceptionHortalsoft exceptionHortalsoft) {
            throw exceptionHortalsoft;
        } catch (Exception exception) {
            throw new ExceptionHortalsoft("Ha ocurrido un error inesperado creando el producto", 500, layer, exception);
        }
    }
}
