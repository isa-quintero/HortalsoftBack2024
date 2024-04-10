package com.hortalSoft.products.backend.application.mapper;

import com.hortalSoft.products.backend.application.dto.OfferDTO;
import com.hortalSoft.products.backend.domain.model.Offer;

//@Mapper(componentModel = "spring", uses = {})
public interface ApplicationOfferMapper extends ApplicationEntityMapper<OfferDTO, Offer> {

}