package com.hortalsoft.products.application.mapper;

import com.hortalsoft.products.application.dto.OfferDTO;
import com.hortalsoft.products.domain.domain.Offer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface ApplicationOfferMapper extends ApplicationEntityMapper<OfferDTO, Offer>{
}
