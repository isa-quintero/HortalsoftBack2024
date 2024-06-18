package com.hortalsoft.products.domain.specification.implementation.pricerange;

import com.hortalsoft.products.domain.entity.PriceRangeEntity;
import com.hortalsoft.products.domain.repository.PriceRangeRepository;
import com.hortalsoft.crosscutting.specificaction.AbstractSpecification;

import java.util.Objects;
import java.util.Optional;

public class PriceRangeExistsByIdSpec extends AbstractSpecification<PriceRangeEntity>  {
    private final PriceRangeRepository priceRangeRepository;

    public PriceRangeExistsByIdSpec(PriceRangeRepository priceRangeRepository) {
        this.priceRangeRepository = priceRangeRepository;
    }

    @Override
    public boolean isSatisfiedBy(PriceRangeEntity priceRangeEntity) {
        Optional<PriceRangeEntity> existingPriceRange = priceRangeRepository.findById(priceRangeEntity.getIdPriceRange());
        return existingPriceRange.filter(entity -> Objects.equals(entity.getIdPriceRange(), priceRangeEntity.getIdPriceRange())).isPresent();    }
}
