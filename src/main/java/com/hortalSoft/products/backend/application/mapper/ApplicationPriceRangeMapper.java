package com.hortalSoft.products.backend.application.mapper;

import com.hortalSoft.products.backend.application.dto.PriceRangeDTO;
import com.hortalSoft.products.backend.application.dto.ProductDTO;
import com.hortalSoft.products.backend.domain.model.PriceRange;
import com.hortalSoft.products.backend.domain.model.Product;

//@Mapper(componentModel = "spring", uses = {})
public interface ApplicationPriceRangeMapper extends ApplicationEntityMapper<PriceRangeDTO, PriceRange> {

}