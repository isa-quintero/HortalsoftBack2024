package com.hortalsoft.products.application.usecase.offer;


import com.hortalsoft.products.domain.domain.Offer;
import com.hortalsoft.products.domain.entity.OfferEntity;
import com.hortalsoft.products.domain.port.offer.ListOfferUseCase;
import com.hortalsoft.products.domain.repository.OfferRepository;
import com.hortalsoft.products.domain.repository.ProductRepository;
import com.hortalsoft.products.util.mapper.MapperEntityToDomain;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionSystemException;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ListOffersService implements ListOfferUseCase {

    private final ProductRepository productRepository;
    private final OfferRepository offerRepository;
    MapperEntityToDomain<OfferEntity,Offer> mapperEntityToDomain = new MapperEntityToDomain<>();


    @Autowired
    public ListOffersService(ProductRepository productRepository, OfferRepository offerRepository) {
        this.productRepository = productRepository;
        this.offerRepository = offerRepository;
    }


    @Override
    public List<Offer> execute(Optional<Offer> domain) {
        try{
            List<OfferEntity> resultList = offerRepository.findAll();
            return mapperEntityToDomain.mapToDomainList(resultList,Offer.class);
        }
        catch(Exception e){
            throw new TransactionSystemException(e.getMessage());
        }
    }

}
