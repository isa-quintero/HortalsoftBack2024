package com.hortalsoft.users.application.mapper;

import com.hortalsoft.users.application.dto.PriceRangeDTO;
import com.hortalsoft.users.domain.domain.PriceRange;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface ApplicationPriceRangeMapper extends ApplicationEntityMapper<PriceRangeDTO, PriceRange> {
}
