package com.hortalsoft.products.domain.port.usecase.pricerange;


import com.hortalsoft.products.domain.domain.PriceRange;
import com.hortalsoft.products.domain.entity.PriceRangeEntity;
import com.hortalsoft.products.domain.port.input.pricerange.FindPriceRangeUseCase;
import com.hortalsoft.products.domain.repository.PriceRangeRepository;
import com.hortalsoft.products.domain.mapper.MapperDomainToEntity;
import com.hortalsoft.products.domain.mapper.MapperEntityToDomain;
import com.hortalsoft.products.util.ExceptionHortalsoft;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
                throw new ExceptionHortalsoft("El rnago de precios no existe",6001);
            }
        }
        catch(Exception e){
            throw e;
        }
    }
}
