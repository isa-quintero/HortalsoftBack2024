package com.hortalsoft.transactions.application.mapper;

import com.hortalsoft.transactions.application.dto.OfferDTO;
import com.hortalsoft.transactions.domain.domain.Offer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface ApplicationOfferMapper extends ApplicationEntityMapper<OfferDTO, Offer> {
}
