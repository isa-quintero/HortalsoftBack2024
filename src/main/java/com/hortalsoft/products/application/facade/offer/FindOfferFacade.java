package com.hortalsoft.products.application.facade.offer;


//import com.hortalsoft.crosscutting.response.usecase.facade.UseCaseFindFacade;
import com.hortalsoft.products.util.usecase.facade.UseCaseFindFacade;
import com.hortalsoft.products.application.dto.OfferDTO;
import com.hortalsoft.products.domain.domain.Offer;

public interface FindOfferFacade extends UseCaseFindFacade<OfferDTO, Offer> {
}
