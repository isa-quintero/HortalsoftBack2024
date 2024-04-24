package com.hortalsoft.products.application.facades.implementation.offer;



import com.hortalsoft.products.application.dto.OfferDTO;
import com.hortalsoft.products.application.facades.facade.offer.FindOfferFacade;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class FindOfferFacadeImpl implements FindOfferFacade {
    @Override
    public OfferDTO execute(OfferDTO dto) {
        return null;
    }
}
