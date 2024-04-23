package com.hortalsoft.products.application.implementation.offer;



import com.hortalsoft.products.application.dto.OfferDTO;
import com.hortalsoft.products.application.facade.offer.FindOfferFacade;
import com.hortalsoft.products.domain.domain.Offer;
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
