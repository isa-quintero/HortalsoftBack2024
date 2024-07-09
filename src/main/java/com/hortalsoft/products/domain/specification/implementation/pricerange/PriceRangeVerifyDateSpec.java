package com.hortalsoft.products.domain.specification.implementation.pricerange;

import com.hortalsoft.crosscutting.helper.DateHelper;
import com.hortalsoft.products.domain.entity.PriceRangeEntity;
import com.hortalsoft.crosscutting.specificaction.AbstractSpecification;

import java.time.LocalDateTime;

public class PriceRangeVerifyDateSpec extends AbstractSpecification<PriceRangeEntity>  {

    public PriceRangeVerifyDateSpec() {

    }

    @Override
    public boolean isSatisfiedBy(PriceRangeEntity priceRangeEntity) {
        return (DateHelper.isGreaterOrEqual(priceRangeEntity.getFinalDatePriceRange(), LocalDateTime.now()) &&
                DateHelper.isGreaterOrEqual(priceRangeEntity.getInitialDatePriceRange(), LocalDateTime.now()) &&
                DateHelper.isGreaterOrEqual(priceRangeEntity.getFinalDatePriceRange(), priceRangeEntity.getInitialDatePriceRange())
        );
    }
}
