package com.hortalsoft.products.domain.port.usecase.offer;

import com.hortalsoft.products.domain.domain.Offer;
import com.hortalsoft.products.domain.entity.OfferEntity;
import com.hortalsoft.products.domain.port.input.offer.CreateOfferUseCase;
import com.hortalsoft.products.domain.repository.OfferRepository;
import com.hortalsoft.products.domain.mapper.MapperDomainToEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionSystemException;

@Service
public class CreateOfferService implements CreateOfferUseCase {

    private final OfferRepository offerRepository;
    MapperDomainToEntity<Offer, OfferEntity> mapperDomainToEntity = new MapperDomainToEntity<>();


    @Autowired
    public CreateOfferService(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;

    }

    @Override
    public void execute(Offer domain) {
        try{

            //TODO realizar validaciones de negocio que un campesino, en un mismo rango de fechas y el mismo producto tenga creada una oferta
            OfferEntity entity =  mapperDomainToEntity.mapToEntity(domain,OfferEntity.class);
            if (!offerRepository.existsById(entity.getId())){
                offerRepository.save(entity);
            }
            else{
                System.out.println("Ya existe una oferta ya existe en el sistema");
            }
        }
        catch(Exception e){
            throw new TransactionSystemException(e.getMessage());
        }
    }
}
