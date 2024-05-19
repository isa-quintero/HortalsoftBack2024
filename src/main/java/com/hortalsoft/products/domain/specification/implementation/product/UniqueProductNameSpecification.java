package com.hortalsoft.products.domain.specification.implementation.product;

import com.hortalsoft.products.domain.entity.ProductEntity;
import com.hortalsoft.products.domain.repository.ProductRepository;
import com.hortalsoft.products.domain.specification.AbstractSpecification;

import java.util.Objects;

public class UniqueProductNameSpecification extends AbstractSpecification<ProductEntity> {
    private final String productName;
    private final ProductRepository productRepository;

    public UniqueProductNameSpecification(String productName, ProductRepository productRepository) {
        this.productName = productName;
        this.productRepository = productRepository;
    }

    @Override
    public boolean isSatisfiedBy(ProductEntity product) {
        ProductEntity existingProduct = productRepository.findByName(productName);
        if (existingProduct == null) {
            return true;
        }
        return Objects.equals(existingProduct.getId(), product.getId());
    }
}
