package com.hortalsoft.products.application.usecase.pricerange;


import com.hortalsoft.products.domain.domain.PriceRange;
import com.hortalsoft.products.domain.entity.PriceRangeEntity;
import com.hortalsoft.products.domain.port.pricerange.ListPricesRangesUseCase;
import com.hortalsoft.products.domain.repository.PriceRangeRepository;
import com.hortalsoft.products.util.mapper.MapperEntityToDomain;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionSystemException;

import java.util.List;

@Service
@Transactional
public class ListPriceRangesService implements ListPricesRangesUseCase {

    private final PriceRangeRepository priceRangeRepository;
    MapperEntityToDomain<PriceRangeEntity,PriceRange> mapperEntityToDomain = new MapperEntityToDomain<>();


    @Autowired
    public ListPriceRangesService(PriceRangeRepository priceRangeRepository) {
        this.priceRangeRepository = priceRangeRepository;
    }


    @Override
    public List<PriceRange> execute() {
        try{
            List<PriceRangeEntity> resultList = priceRangeRepository.findAll();
            return mapperEntityToDomain.mapToDomainList(resultList,PriceRange.class);
        }
        catch(Exception e){
            throw new TransactionSystemException(e.getMessage());
        }
    }
}
