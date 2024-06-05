package com.hortalsoft.products.domain.specification.implementation.pricerange;

import com.hortalsoft.crosscutting.helper.DateHelper;
import com.hortalsoft.products.domain.entity.PriceRangeEntity;
import com.hortalsoft.products.domain.repository.PriceRangeRepository;
import com.hortalsoft.products.domain.specification.AbstractSpecification;

import java.time.LocalDateTime;

public class PriceRangeVerifyDateSpec extends AbstractSpecification<PriceRangeEntity>  {
    private final PriceRangeRepository priceRangeRepository;

    public PriceRangeVerifyDateSpec(PriceRangeRepository priceRangeRepository) {
        this.priceRangeRepository = priceRangeRepository;
    }

    @Override
    public boolean isSatisfiedBy(PriceRangeEntity priceRangeEntity) {
        return (DateHelper.isGreaterOrEqual(priceRangeEntity.getFinalDatePriceRange(), LocalDateTime.now()) &&
                DateHelper.isGreaterOrEqual(priceRangeEntity.getInitialDatePriceRange(), LocalDateTime.now()) &&
                DateHelper.isGreaterOrEqual(priceRangeEntity.getFinalDatePriceRange(), priceRangeEntity.getInitialDatePriceRange())
        );
    }
}
