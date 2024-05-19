package com.hortalsoft.products.domain.specification.implementation.product;

import com.hortalsoft.products.domain.entity.ProductEntity;
import com.hortalsoft.products.domain.repository.ProductRepository;
import com.hortalsoft.products.domain.specification.AbstractSpecification;

import java.util.Objects;
import java.util.Optional;

public class ProductExistsByIdSpecification extends AbstractSpecification<ProductEntity> {
    private final ProductRepository productRepository;

    public ProductExistsByIdSpecification( ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public boolean isSatisfiedBy(ProductEntity product) {
        Optional<ProductEntity> existingProduct = productRepository.findById(product.getId());
        return Objects.equals(existingProduct.get().getId(), product.getId());
    }
}