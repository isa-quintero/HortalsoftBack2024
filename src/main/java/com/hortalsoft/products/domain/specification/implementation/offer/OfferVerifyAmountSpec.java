package com.hortalsoft.products.domain.specification.implementation.offer;

import com.hortalsoft.products.domain.entity.OfferEntity;
import com.hortalsoft.products.domain.specification.AbstractSpecification;

public class OfferVerifyAmountSpec extends AbstractSpecification<OfferEntity> {

    public OfferVerifyAmountSpec() {
    }

    @Override
    public boolean isSatisfiedBy(OfferEntity offerEntity) {
        return offerEntity.getAmount()>0;
    }
}
