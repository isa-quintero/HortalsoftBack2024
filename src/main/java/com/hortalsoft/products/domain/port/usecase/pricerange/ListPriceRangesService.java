package com.hortalsoft.products.domain.port.usecase.pricerange;


import com.hortalsoft.products.domain.domain.PriceRange;
import com.hortalsoft.products.domain.entity.PriceRangeEntity;
import com.hortalsoft.products.domain.port.input.pricerange.ListPricesRangesUseCase;
import com.hortalsoft.products.domain.repository.PriceRangeRepository;
import com.hortalsoft.products.domain.mapper.MapperEntityToDomain;
import com.hortalsoft.crosscutting.util.ExceptionHortalsoft;
import com.hortalsoft.crosscutting.util.Layer;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ListPriceRangesService implements ListPricesRangesUseCase {

    private static final Layer layer = Layer.DOMAIN;
    private final PriceRangeRepository priceRangeRepository;
    MapperEntityToDomain<PriceRangeEntity, PriceRange> mapperEntityToDomain = new MapperEntityToDomain<>();


    @Autowired
    public ListPriceRangesService(PriceRangeRepository priceRangeRepository) {
        this.priceRangeRepository = priceRangeRepository;
    }

    @Override
    public List<PriceRange> execute() {
        try {
            if (priceRangeRepository.count() != 0) {
                List<PriceRangeEntity> resultList = priceRangeRepository.findAllByFinalDateValid();
                return mapperEntityToDomain.mapToDomainList(resultList, PriceRange.class);
            } else {
                throw new ExceptionHortalsoft("No hay rangos de precios vigentes para mostrar", 6001, layer);
            }
        } catch (ExceptionHortalsoft exceptionHortalsoft) {
            throw exceptionHortalsoft;
        } catch (Exception exception) {
            throw new ExceptionHortalsoft("Ha ocurrido un error inesperado listando los rangos de precios", 500, layer, exception);
        }
    }
}
