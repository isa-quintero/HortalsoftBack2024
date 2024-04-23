package com.hortalsoft.products.application.implementation.offer;

import com.hortalsoft.products.application.dto.OfferDTO;
import com.hortalsoft.products.application.facade.offer.ListOfferFacade;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ListOfferFacadeImpl implements ListOfferFacade {
    @Override
    public List<OfferDTO> execute(Optional<OfferDTO> dto) {
        return List.of();
    }
}
