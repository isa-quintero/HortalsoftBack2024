package com.hortalsoft.products.backend.application.mapper;

import com.hortalsoft.products.backend.application.dto.PriceRangeDTO;
import com.hortalsoft.products.backend.domain.domain.PriceRange;

//@Mapper(componentModel = "spring", uses = {})
public interface ApplicationPriceRangeMapper extends ApplicationEntityMapper<PriceRangeDTO, PriceRange> {

}