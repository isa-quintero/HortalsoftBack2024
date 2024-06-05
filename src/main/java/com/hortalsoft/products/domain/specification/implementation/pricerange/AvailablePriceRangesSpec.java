package com.hortalsoft.products.domain.specification.implementation.pricerange;

import com.hortalsoft.products.domain.entity.PriceRangeEntity;
import com.hortalsoft.products.domain.repository.PriceRangeRepository;
import com.hortalsoft.products.domain.specification.AbstractSpecification;

public class AvailablePriceRangesSpec extends AbstractSpecification<PriceRangeEntity> {
    private final PriceRangeRepository priceRangeRepository;

    public AvailablePriceRangesSpec(PriceRangeRepository priceRangeRepository) {
        this.priceRangeRepository = priceRangeRepository;
    }

    @Override
    public boolean isSatisfiedBy(PriceRangeEntity priceRangeEntity) {
        return false;
    }
}
