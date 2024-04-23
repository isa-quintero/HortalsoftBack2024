package com.hortalsoft.products.application.usecase.offer;


import com.hortalsoft.products.domain.domain.Offer;
import com.hortalsoft.products.domain.domain.Product;
import com.hortalsoft.products.domain.entity.OfferEntity;
import com.hortalsoft.products.domain.entity.ProductEntity;
import com.hortalsoft.products.domain.port.offer.FindOfferUseCase;
import com.hortalsoft.products.domain.port.product.FindProductUseCase;
import com.hortalsoft.products.domain.repository.OfferRepository;
import com.hortalsoft.products.domain.repository.ProductRepository;
import com.hortalsoft.products.util.mapper.MapperDomainToEntity;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionSystemException;

import java.util.Optional;

@Service
@Transactional
public class FindOfferService implements FindOfferUseCase {

    private final OfferRepository offerRepository;
    MapperDomainToEntity<Offer,OfferEntity> mapperDomainToEntity = new MapperDomainToEntity();


    @Autowired
    public FindOfferService(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;

    }


    @Override
    public OfferEntity execute(Offer domain) {
        try{
            if(offerRepository.existsById(domain.getId())){
                OfferEntity entity =  mapperDomainToEntity.mapToEntity(domain,OfferEntity.class);
                Optional<OfferEntity> result =  offerRepository.findById(entity.getId());
                return result.orElse(null);
            }
            else{
                System.out.println("El producto no existe");
                return null;
            }

        }
        catch(Exception e){
            throw new TransactionSystemException(e.getMessage());

        }

    }
}
