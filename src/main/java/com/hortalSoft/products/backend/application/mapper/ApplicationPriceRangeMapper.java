package com.hortalSoft.products.backend.application.mapper;

import com.hortalSoft.products.backend.application.dto.PriceRangeDTO;
import com.hortalSoft.products.backend.domain.model.PriceRange;

//@Mapper(componentModel = "spring", uses = {})
public interface ApplicationPriceRangeMapper extends ApplicationEntityMapper<PriceRangeDTO, PriceRange> {

}