package com.hortalsoft.products.domain.specification.implementation.product;

import com.hortalsoft.products.domain.entity.ProductEntity;
import com.hortalsoft.crosscutting.specificaction.AbstractSpecification;

import java.util.Objects;

public class EmptyAttributesProductSpec extends AbstractSpecification<ProductEntity> {
    @Override
    public boolean isSatisfiedBy(ProductEntity product) {
        return Objects.equals(product.getName(),"") || Objects.equals(product.getSubcategory(),0);
    }
}
