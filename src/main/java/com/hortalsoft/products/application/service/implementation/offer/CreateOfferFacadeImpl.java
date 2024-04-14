package com.hortalsoft.products.application.service.implementation.offer;


import com.hortalsoft.products.application.dto.OfferDTO;
import com.hortalsoft.products.application.service.facade.offer.CreateOfferFacade;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CreateOfferFacadeImpl implements CreateOfferFacade {


    @Override
    public void execute(OfferDTO dto) {
    }
}
