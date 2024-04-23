package com.hortalsoft.products.domain.port.offer;

import com.hortalsoft.crosscutting.response.usecase.domain.UseCaseFindDomain;
import com.hortalsoft.products.domain.domain.Offer;
import com.hortalsoft.products.domain.entity.OfferEntity;

public interface FindOfferUseCase extends UseCaseFindDomain<Offer> {
}
