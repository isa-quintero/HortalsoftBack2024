package com.hortalsoft.products.application.facade.pricerange;

//import com.hortalsoft.crosscutting.response.usecase.facade.UseCaseFindFacade;
import com.hortalsoft.products.util.usecase.facade.UseCaseFindFacade;
import com.hortalsoft.products.application.dto.PriceRangeDTO;
import com.hortalsoft.products.domain.domain.PriceRange;


public interface FindPriceRangeFacade extends UseCaseFindFacade<PriceRangeDTO, PriceRange> {
}
