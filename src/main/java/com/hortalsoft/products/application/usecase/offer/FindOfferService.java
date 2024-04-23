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
    MapperDomainToEntity<Offer,OfferEntity> mapperDomainToEntity = new MapperDomainToEntity();
    MapperEntityToDomain<Optional<OfferEntity>,Offer> mapperEntityToDomain = new MapperEntityToDomain<>();

    @Autowired
    public FindOfferService(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;

    }


    @Override
    public Offer execute(Offer domain) {
        try{
            if(offerRepository.existsById(domain.getId())){
                OfferEntity entity =  mapperDomainToEntity.mapToEntity(domain,OfferEntity.class);
                Optional<OfferEntity> optional = offerRepository.findById(entity.getId());
                Offer result =  mapperEntityToDomain.mapToDomain(optional,Offer.class);
                return result;
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
