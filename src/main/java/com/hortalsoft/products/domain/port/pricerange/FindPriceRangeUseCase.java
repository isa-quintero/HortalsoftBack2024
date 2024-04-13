package com.hortalsoft.products.domain.port.pricerange;

import com.hortalsoft.crosscutting.response.usecase.domain.UseCaseFindDomain;
import com.hortalsoft.products.domain.domain.PriceRange;
import com.hortalsoft.products.domain.entity.PriceRangeEntity;

public interface FindPriceRangeUseCase extends UseCaseFindDomain<PriceRange, PriceRangeEntity> {
}
