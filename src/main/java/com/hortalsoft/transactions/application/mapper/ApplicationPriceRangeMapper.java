package com.hortalsoft.transactions.application.mapper;

import com.hortalsoft.transactions.application.dto.PriceRangeDTO;
import com.hortalsoft.transactions.domain.domain.PriceRange;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface ApplicationPriceRangeMapper extends ApplicationEntityMapper<PriceRangeDTO, PriceRange> {
}
