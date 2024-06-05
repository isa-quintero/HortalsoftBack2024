package com.hortalsoft.products.domain.specification.implementation.pricerange;

import com.hortalsoft.products.domain.entity.PriceRangeEntity;
import com.hortalsoft.products.domain.repository.PriceRangeRepository;
import com.hortalsoft.products.domain.specification.AbstractSpecification;

public class PriceRangeVerifyProductSpec extends AbstractSpecification<PriceRangeEntity> {
    private final PriceRangeRepository priceRangeRepository;

    public PriceRangeVerifyProductSpec(PriceRangeRepository priceRangeRepository) {
        this.priceRangeRepository = priceRangeRepository;
    }

    @Override
    public boolean isSatisfiedBy(PriceRangeEntity priceRangeEntity) {
        return false;
    }
}
