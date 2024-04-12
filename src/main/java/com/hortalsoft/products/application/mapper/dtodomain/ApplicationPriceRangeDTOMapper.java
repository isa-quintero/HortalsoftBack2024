package com.hortalsoft.products.application.mapper.dtodomain;

import com.hortalsoft.crosscutting.response.ApplicationDTOMapper;
import com.hortalsoft.products.application.dto.PriceRangeDTO;
import com.hortalsoft.products.domain.domain.PriceRange;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ApplicationPriceRangeDTOMapper extends ApplicationDTOMapper<PriceRangeDTO, PriceRange> {
}
