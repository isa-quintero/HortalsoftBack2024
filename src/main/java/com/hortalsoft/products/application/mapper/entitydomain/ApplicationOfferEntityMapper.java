package com.hortalsoft.products.application.mapper.entitydomain;

import com.hortalsoft.crosscutting.response.ApplicationEntityMapper;
import com.hortalsoft.products.domain.domain.Offer;
import com.hortalsoft.products.domain.entity.OfferEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ApplicationOfferEntityMapper extends ApplicationEntityMapper<OfferEntity, Offer> {
}
