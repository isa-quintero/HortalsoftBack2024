package com.hortalsoft.products.domain.specification.implementation.pricerange;

import com.hortalsoft.products.domain.entity.PriceRangeEntity;
import com.hortalsoft.crosscutting.specificaction.AbstractSpecification;

public class PriceRangeVerifyValiditySpec extends AbstractSpecification<PriceRangeEntity> {


    public PriceRangeVerifyValiditySpec() {
    }

    @Override
    public boolean isSatisfiedBy(PriceRangeEntity priceRangeEntity) {
        return !priceRangeEntity.isValidity();
    }
}
