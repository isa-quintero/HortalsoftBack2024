package com.hortalsoft.products.domain.specification.implementation.pricerange;

import com.hortalsoft.crosscutting.specificaction.AbstractSpecification;
import com.hortalsoft.products.domain.entity.PriceRangeEntity;

import java.util.Objects;

public class EmptyAttributesPriceRangeSpec extends AbstractSpecification<PriceRangeEntity> {

    @Override
    public boolean isSatisfiedBy(PriceRangeEntity priceRange) {
        return (Objects.equals(priceRange.getProduct(), 0) || Objects.equals(priceRange.getAssociationId(), 0) ||
                Objects.equals(priceRange.getInitialRange(), 0) || Objects.equals(priceRange.getFinalRange(), 0));

    }
}
