package com.hortalsoft.products.application.mapper.dtodomain;

import com.hortalsoft.crosscutting.response.ApplicationDTOMapper;
import com.hortalsoft.products.application.dto.OfferDTO;
import com.hortalsoft.products.domain.domain.Offer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ApplicationOfferDTOMapper extends ApplicationDTOMapper<OfferDTO, Offer> {
}
