package com.hortalsoft.products.domain.specification.implementation.product;

import com.hortalsoft.products.domain.entity.ProductEntity;
import com.hortalsoft.products.domain.repository.ProductRepository;
import com.hortalsoft.crosscutting.specificaction.AbstractSpecification;

import java.util.Objects;
import java.util.Optional;

public class ProductExistsByIdSpec extends AbstractSpecification<ProductEntity> {
    private final ProductRepository productRepository;

    public ProductExistsByIdSpec(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public boolean isSatisfiedBy(ProductEntity product) {
        Optional<ProductEntity> existingProduct = productRepository.findById(product.getIdProduct());
        return existingProduct.filter(entity -> Objects.equals(entity.getIdProduct(), product.getIdProduct())).isPresent();
    }
}