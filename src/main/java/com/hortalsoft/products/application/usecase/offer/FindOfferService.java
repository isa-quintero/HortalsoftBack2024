package com.hortalsoft.products.application.usecase.offer;


import com.hortalsoft.products.domain.domain.Offer;
import com.hortalsoft.products.domain.entity.OfferEntity;
import com.hortalsoft.products.domain.port.offer.FindOfferUseCase;
import com.hortalsoft.products.domain.repository.OfferRepository;
import com.hortalsoft.products.util.mapper.MapperDomainToEntity;
import com.hortalsoft.products.util.mapper.MapperEntityToDomain;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionSystemException;

import java.util.Optional;

@Service
@Transactional
public class FindOfferService implements FindOfferUseCase {

    private final OfferRepository offerRepository;
    MapperDomainToEntity<Offer,OfferEntity> mapperDomainToEntity = new MapperDomainToEntity<>();
    MapperEntityToDomain<OfferEntity,Offer> mapperEntityToDomain = new MapperEntityToDomain<>();

    @Autowired
    public FindOfferService(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;

    }


    @Override
    public Offer execute(Offer domain) {
        try{
            OfferEntity entity =  mapperDomainToEntity.mapToEntity(domain,OfferEntity.class);
            Optional<OfferEntity> resultEntity= offerRepository.findById(entity.getId());
            if (resultEntity.isPresent()) {
                return mapperEntityToDomain.mapToDomain(resultEntity.get(),Offer.class);
            }
            else{
                System.out.println("La oferta no existe");
                return null;
            }

        }
        catch(Exception e){
            throw new TransactionSystemException(e.getMessage());

        }

    }
}
