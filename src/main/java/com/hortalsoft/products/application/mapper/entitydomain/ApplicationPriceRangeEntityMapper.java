package com.hortalsoft.products.application.mapper.entitydomain;

import com.hortalsoft.crosscutting.response.ApplicationEntityMapper;
import com.hortalsoft.products.domain.domain.PriceRange;
import com.hortalsoft.products.domain.entity.PriceRangeEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ApplicationPriceRangeEntityMapper extends ApplicationEntityMapper<PriceRangeEntity, PriceRange> {
}
