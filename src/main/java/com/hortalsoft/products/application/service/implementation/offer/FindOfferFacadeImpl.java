package com.hortalsoft.products.application.service.implementation.offer;



import com.hortalsoft.products.application.dto.OfferDTO;
import com.hortalsoft.products.application.service.facade.offer.FindOfferFacade;
import com.hortalsoft.products.domain.domain.Offer;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class FindOfferFacadeImpl implements FindOfferFacade {
    @Override
    public Offer execute(OfferDTO dto) {
        return null;
    }
}
