package com.hortalsoft.products.application.usecase.offer;


import com.hortalsoft.products.domain.domain.Offer;
import com.hortalsoft.products.domain.entity.OfferEntity;
import com.hortalsoft.products.domain.port.offer.DisableOfferUseCase;
import com.hortalsoft.products.domain.repository.OfferRepository;
import com.hortalsoft.products.util.mapper.MapperDomainToEntity;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionSystemException;

import java.util.Optional;

@Service
@Transactional
public class DisableOfferService implements DisableOfferUseCase {

    private final OfferRepository offerRepository;
    MapperDomainToEntity<Offer, OfferEntity> mapperDomainToEntity = new MapperDomainToEntity();


    @Autowired
    public DisableOfferService(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;

    }

    @Override
    public void execute(Offer domain) {
        try{
            Optional<OfferEntity> findbyId = offerRepository.findById(domain.getId());
            if(findbyId.get() != null){
                offerRepository.delete(findbyId.get());
            }
            else{
                System.out.println("El producto no existe");
            }
        }
        catch(Exception e){
            throw new TransactionSystemException(e.getMessage());
        }
    }
}
