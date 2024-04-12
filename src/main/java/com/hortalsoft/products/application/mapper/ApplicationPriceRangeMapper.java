package com.hortalsoft.products.application.mapper;

import com.hortalsoft.crosscutting.response.ApplicationEntityMapper;
import com.hortalsoft.products.application.dto.PriceRangeDTO;
import com.hortalsoft.products.domain.domain.PriceRange;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface ApplicationPriceRangeMapper extends ApplicationEntityMapper<PriceRangeDTO, PriceRange> {
}
