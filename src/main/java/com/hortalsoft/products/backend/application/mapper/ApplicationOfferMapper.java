package com.hortalsoft.products.backend.application.mapper;

import com.hortalsoft.products.backend.application.dto.OfferDTO;
import com.hortalsoft.products.backend.domain.domain.Offer;

//@Mapper(componentModel = "spring", uses = {})
public interface ApplicationOfferMapper extends ApplicationEntityMapper<OfferDTO, Offer> {

}