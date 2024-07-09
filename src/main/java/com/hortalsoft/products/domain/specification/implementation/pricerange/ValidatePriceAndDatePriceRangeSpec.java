package com.hortalsoft.products.domain.specification.implementation.pricerange;

import com.hortalsoft.crosscutting.specificaction.AbstractSpecification;
import com.hortalsoft.products.domain.entity.PriceRangeEntity;


public class ValidatePriceAndDatePriceRangeSpec extends AbstractSpecification<PriceRangeEntity>{
    private final AbstractSpecification<PriceRangeEntity> reglaA;
    private final AbstractSpecification<PriceRangeEntity> reglaB;

    public ValidatePriceAndDatePriceRangeSpec() {
        reglaA = new PriceRangeVerifyPriceSpec();
        reglaB = new PriceRangeVerifyDateSpec();
    }

    @Override
    public boolean isSatisfiedBy(PriceRangeEntity priceRangeEntity) {
        return reglaA.and(reglaB).isSatisfiedBy(priceRangeEntity);
    }
}
