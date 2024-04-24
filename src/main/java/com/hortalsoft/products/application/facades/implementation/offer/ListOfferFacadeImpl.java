package com.hortalsoft.products.application.facades.implementation.offer;

import com.hortalsoft.products.application.dto.OfferDTO;
import com.hortalsoft.products.application.facades.facade.offer.ListOfferFacade;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ListOfferFacadeImpl implements ListOfferFacade {

    @Override
    public List<OfferDTO> execute() {
        return List.of();
    }
}
