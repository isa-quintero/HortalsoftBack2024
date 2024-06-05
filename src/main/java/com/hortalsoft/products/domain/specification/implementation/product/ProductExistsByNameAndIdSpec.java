package com.hortalsoft.products.domain.specification.implementation.product;

import com.hortalsoft.products.domain.entity.ProductEntity;
import com.hortalsoft.products.domain.repository.ProductRepository;
import com.hortalsoft.products.domain.specification.AbstractSpecification;

public class ProductExistsByNameAndIdSpec extends AbstractSpecification<ProductEntity> {

    private final AbstractSpecification<ProductEntity> reglaA;
    private final AbstractSpecification<ProductEntity> reglaB;


    public ProductExistsByNameAndIdSpec(ProductRepository productRepository) {
        reglaA = new ProductExistsByIdSpec(productRepository);
        reglaB = new UniqueProductNameSpec(productRepository);
    }

    @Override
    public boolean isSatisfiedBy(ProductEntity product) {
        return reglaA.and(reglaB).isSatisfiedBy(product);
    }
}
