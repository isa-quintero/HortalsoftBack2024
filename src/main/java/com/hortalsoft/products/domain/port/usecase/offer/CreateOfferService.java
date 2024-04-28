package com.hortalsoft.products.domain.port.usecase.offer;

import com.hortalsoft.products.domain.domain.Offer;
import com.hortalsoft.products.domain.entity.OfferEntity;
import com.hortalsoft.products.domain.port.input.offer.CreateOfferUseCase;
import com.hortalsoft.products.domain.repository.OfferRepository;
import com.hortalsoft.products.domain.mapper.MapperDomainToEntity;
import com.hortalsoft.products.util.ExceptionHortalsoft;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateOfferService implements CreateOfferUseCase {

    private final OfferRepository offerRepository;
    private final FindOfferService findOfferService;
    MapperDomainToEntity<Offer, OfferEntity> mapperDomainToEntity = new MapperDomainToEntity<>();


    @Autowired
    public CreateOfferService(OfferRepository offerRepository, FindOfferService findOfferService) {
        this.offerRepository = offerRepository;
        this.findOfferService = findOfferService;
    }

    @Override
    public void execute(Offer domain) {
        try{
            OfferEntity entity =  mapperDomainToEntity.mapToEntity(domain,OfferEntity.class);
            if (offerRepository.findByCodeProductAndInitialDateAndCodeFarmer(entity.getCodeProduct(),entity.getInitialDate(), entity.getCodeFarmer()) != null) {
                offerRepository.save(entity);
            }
            else{
                throw  new ExceptionHortalsoft("La oferta ya existe", 5001);
            }
        }
        catch(Exception e){
            throw e;
        }
    }
}
