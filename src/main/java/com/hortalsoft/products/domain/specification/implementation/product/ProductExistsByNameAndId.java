package com.hortalsoft.products.domain.specification.implementation.product;

import com.hortalsoft.products.domain.entity.ProductEntity;
import com.hortalsoft.products.domain.repository.ProductRepository;
import com.hortalsoft.products.domain.specification.AbstractSpecification;

public class ProductExistsByNameAndId extends AbstractSpecification<ProductEntity> {

    private final AbstractSpecification<ProductEntity> regla1;
    private final AbstractSpecification<ProductEntity> regla2;


    public ProductExistsByNameAndId(ProductRepository productRepository) {
        regla1 = new ProductExistsByIdSpecification(productRepository);
        regla2 = new UniqueProductNameSpecification(productRepository);
    }

    @Override
    public boolean isSatisfiedBy(ProductEntity product) {
        return regla1.and(regla2).isSatisfiedBy(product);
    }
}
