package com.hortalsoft.products.domain.port.usecase.offer;


import com.hortalsoft.products.domain.domain.Offer;
import com.hortalsoft.products.domain.entity.OfferEntity;
import com.hortalsoft.products.domain.port.input.offer.ListOfferUseCase;
import com.hortalsoft.products.domain.repository.OfferRepository;
import com.hortalsoft.products.domain.mapper.MapperEntityToDomain;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionSystemException;

import java.util.List;

@Service
@Transactional
public class ListOffersService implements ListOfferUseCase {

    private final OfferRepository offerRepository;
    MapperEntityToDomain<OfferEntity, Offer> mapperEntityToDomain = new MapperEntityToDomain<>();


    @Autowired
    public ListOffersService(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }


    @Override
    public List<Offer> execute() {
        try{
            List<OfferEntity> resultList = offerRepository.findAll();
            return mapperEntityToDomain.mapToDomainList(resultList,Offer.class);
        }
        catch(Exception e){
            throw new TransactionSystemException(e.getMessage());
        }
    }

}
