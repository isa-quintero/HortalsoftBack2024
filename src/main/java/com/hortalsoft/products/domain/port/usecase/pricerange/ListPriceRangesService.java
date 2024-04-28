package com.hortalsoft.products.domain.port.usecase.pricerange;


import com.hortalsoft.products.domain.domain.PriceRange;
import com.hortalsoft.products.domain.entity.PriceRangeEntity;
import com.hortalsoft.products.domain.port.input.pricerange.ListPricesRangesUseCase;
import com.hortalsoft.products.domain.repository.PriceRangeRepository;
import com.hortalsoft.products.domain.mapper.MapperEntityToDomain;
import com.hortalsoft.products.util.ExceptionHortalsoft;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
            if (priceRangeRepository.count() != 0) {
                List<PriceRangeEntity> resultList = priceRangeRepository.findAll();
                return mapperEntityToDomain.mapToDomainList(resultList, PriceRange.class);
            }else{
                throw  new ExceptionHortalsoft("No hay rangos de precios para mostrar", 6001,"Domain");
            }
        }
        catch(Exception e){
            if (e instanceof ExceptionHortalsoft){
                throw (ExceptionHortalsoft) e;
            }else{
                throw new ExceptionHortalsoft(e.getMessage(),500,"Domain");
            }
        }
    }
}
