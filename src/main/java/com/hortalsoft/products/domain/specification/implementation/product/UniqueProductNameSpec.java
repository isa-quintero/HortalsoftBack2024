package com.hortalsoft.products.domain.specification.implementation.product;

import com.hortalsoft.products.domain.entity.ProductEntity;
import com.hortalsoft.products.domain.repository.ProductRepository;
import com.hortalsoft.crosscutting.specificaction.AbstractSpecification;

import java.util.Objects;

public class UniqueProductNameSpec extends AbstractSpecification<ProductEntity> {
    private final ProductRepository productRepository;

    public UniqueProductNameSpec(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public boolean isSatisfiedBy(ProductEntity product) {
        ProductEntity existingProduct = productRepository.findByName(product.getName());
        if (existingProduct == null) {
            return true;
        }
        return Objects.equals(existingProduct.getIdProduct(), product.getIdProduct());
    }
}
