package com.hortalsoft.products.domain.port.usecase.product;


import com.hortalsoft.products.domain.domain.Product;
import com.hortalsoft.products.domain.entity.ProductEntity;
import com.hortalsoft.products.domain.port.input.product.CreateProductUseCase;
import com.hortalsoft.products.domain.repository.ProductRepository;
import com.hortalsoft.products.domain.mapper.MapperDomainToEntity;
import com.hortalsoft.products.domain.specification.implementation.UniqueProductNameSpecification;
import com.hortalsoft.crosscutting.util.ExceptionHortalsoft;
import com.hortalsoft.crosscutting.util.Layers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CreateProductService implements CreateProductUseCase {

    private final ProductRepository productRepository;
    MapperDomainToEntity<Product,ProductEntity> mapperDomainToEntity = new MapperDomainToEntity<>();


    @Autowired
    public CreateProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;

    }

    @Override
    public void execute(Product domain) {
        try {
            UniqueProductNameSpecification uniqueNameSpec = new UniqueProductNameSpecification(domain.getName(), productRepository);
            ProductEntity entity = mapperDomainToEntity.mapToEntity(domain, ProductEntity.class);

            if (uniqueNameSpec.isSatisfiedBy(entity)) {
                productRepository.save(entity);
            } else {
                throw new ExceptionHortalsoft("El producto ya existe", 5001, Layers.DOMAIN);
            }
        } catch (Exception e) {
            if (e instanceof ExceptionHortalsoft) {
                throw (ExceptionHortalsoft) e;
            } else {
                throw new ExceptionHortalsoft(e.getMessage(), 500, Layers.DOMAIN);
            }
        }
    }
}
