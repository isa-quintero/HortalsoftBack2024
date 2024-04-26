package com.hortalsoft.products.domain.port.usecase.pricerange;


import com.hortalsoft.products.domain.domain.PriceRange;
import com.hortalsoft.products.domain.entity.PriceRangeEntity;
import com.hortalsoft.products.domain.port.input.pricerange.FindPriceRangeUseCase;
import com.hortalsoft.products.domain.repository.PriceRangeRepository;
import com.hortalsoft.products.domain.mapper.MapperDomainToEntity;
import com.hortalsoft.products.domain.mapper.MapperEntityToDomain;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionSystemException;

import java.util.Optional;

@Service
@Transactional
public class FindPriceRangeService implements FindPriceRangeUseCase {

    private final PriceRangeRepository priceRangeRepository;
    MapperDomainToEntity<PriceRange, PriceRangeEntity> mapperDomainToEntity = new MapperDomainToEntity<>();
    MapperEntityToDomain<PriceRangeEntity,PriceRange> mapperEntityToDomain = new MapperEntityToDomain<>();

    @Autowired
    public FindPriceRangeService(PriceRangeRepository priceRangeRepository) {
        this.priceRangeRepository = priceRangeRepository;

    }


    @Override
    public PriceRange execute(PriceRange domain) {
        try{
            PriceRangeEntity entity =  mapperDomainToEntity.mapToEntity(domain,PriceRangeEntity.class);
            Optional<PriceRangeEntity> resultEntity= priceRangeRepository.findById(entity.getId());
            if (resultEntity.isPresent()) {
                return mapperEntityToDomain.mapToDomain(resultEntity.get(),PriceRange.class);
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
