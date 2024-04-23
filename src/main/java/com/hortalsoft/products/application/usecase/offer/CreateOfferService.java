package com.hortalsoft.products.application.usecase.offer;

import com.hortalsoft.products.domain.domain.Offer;
import com.hortalsoft.products.domain.entity.OfferEntity;
import com.hortalsoft.products.domain.port.offer.CreateOfferUseCase;
import com.hortalsoft.products.domain.repository.OfferRepository;
import com.hortalsoft.products.util.mapper.MapperDomainToEntity;
import org.springframework.stereotype.Service;

@Service
public class CreateOfferService implements CreateOfferUseCase {
    private final OfferRepository offerRepository;
    MapperDomainToEntity<Offer, OfferEntity> mapperDomainToEntity=new MapperDomainToEntity<>();

    public CreateOfferService(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }
    @Override
    public void execute(Offer domain) {
        try {
            OfferEntity entity = mapperDomainToEntity.mapToEntity(domain, OfferEntity.class);
            offerRepository.save(entity);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
