package com.hortalsoft.users.application.mapper;

import com.hortalsoft.users.application.dto.OfferDTO;
import com.hortalsoft.users.domain.domain.Offer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface ApplicationOfferMapper extends ApplicationEntityMapper<OfferDTO, Offer> {
}
