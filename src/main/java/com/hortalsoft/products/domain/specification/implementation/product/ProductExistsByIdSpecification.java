package com.hortalsoft.products.domain.specification.implementation.product;

import com.hortalsoft.products.domain.entity.ProductEntity;
import com.hortalsoft.products.domain.repository.ProductRepository;
import com.hortalsoft.products.domain.specification.AbstractSpecification;

import java.util.Objects;
import java.util.Optional;

public class ProductExistsByIdSpecification extends AbstractSpecification<ProductEntity> {
    private final int productId;
    private  final ProductRepository productRepository;

    public ProductExistsByIdSpecification(int productId, ProductRepository productRepository) {
        this.productId = productId;
        this.productRepository = productRepository;
    }

    @Override
    public boolean isSatisfiedBy(ProductEntity product) {
        Optional<ProductEntity> existingProduct = productRepository.findById(productId);
        return Objects.equals(existingProduct.get().getId(), product.getId());
    }
}