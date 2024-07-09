package com.hortalsoft.products.domain.specification.implementation.pricerange;

import com.hortalsoft.crosscutting.helper.NumberHelper;
import com.hortalsoft.crosscutting.specificaction.AbstractSpecification;
import com.hortalsoft.products.domain.entity.PriceRangeEntity;
import com.hortalsoft.products.domain.repository.PriceRangeRepository;


public class PriceRangeVerifyPriceSpec extends AbstractSpecification<PriceRangeEntity>  {

    public PriceRangeVerifyPriceSpec() {
    }

    @Override
    public boolean isSatisfiedBy(PriceRangeEntity priceRangeEntity) {
        return (NumberHelper.greaterThan(priceRangeEntity.getInitialRange(),0) &&
                NumberHelper.greaterThan(priceRangeEntity.getFinalRange(),0) &&
                NumberHelper.greaterEqualsThan(priceRangeEntity.getFinalRange(), priceRangeEntity.getInitialRange())
        );
    }
}
