package com.hortalsoft.products.domain.port.usecase.pricerange;


import com.hortalsoft.crosscutting.util.ExceptionHortalsoft;
import com.hortalsoft.crosscutting.util.Layer;
import com.hortalsoft.products.domain.domain.PriceRange;
import com.hortalsoft.products.domain.entity.PriceRangeEntity;
import com.hortalsoft.products.domain.mapper.MapperDomainToEntity;
import com.hortalsoft.products.domain.mapper.MapperEntityToDomain;
import com.hortalsoft.products.domain.port.input.pricerange.ListPricesRangesByAssociationUseCase;
import com.hortalsoft.products.domain.repository.PriceRangeRepository;
import com.hortalsoft.products.domain.specification.implementation.pricerange.PriceRangeExistsByAssociationSpec;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ListPriceRangesByAssociationService implements ListPricesRangesByAssociationUseCase {

    private static final Layer layer = Layer.DOMAIN;
    private final PriceRangeRepository priceRangeRepository;
    MapperEntityToDomain<PriceRangeEntity, PriceRange> mapperEntityToDomain = new MapperEntityToDomain<>();
    MapperDomainToEntity<PriceRange, PriceRangeEntity> mapperDomainToEntity = new MapperDomainToEntity<>();


    @Autowired
    public ListPriceRangesByAssociationService(PriceRangeRepository priceRangeRepository) {
        this.priceRangeRepository = priceRangeRepository;
    }

    @Override
    public List<PriceRange> execute(PriceRange domain) {
        try {
            PriceRangeExistsByAssociationSpec priceRangeExistsByAssociationSpec = new PriceRangeExistsByAssociationSpec(priceRangeRepository);
            PriceRangeEntity entity = mapperDomainToEntity.mapToEntity(domain, PriceRangeEntity.class);
            if (!priceRangeExistsByAssociationSpec.isSatisfiedBy(entity)) {
                List<PriceRangeEntity> resultList = priceRangeRepository.findByAssociationId(entity.getAssociationId());
                return mapperEntityToDomain.mapToDomainList(resultList, PriceRange.class);
            } else {
                throw new ExceptionHortalsoft("No tiene rangos de precios disponibles", 6001, layer);
            }
        } catch (ExceptionHortalsoft exceptionHortalsoft) {
            throw exceptionHortalsoft;
        } catch (Exception exception) {
            throw new ExceptionHortalsoft("Ha ocurrido un error inesperado listando los rangos de precios", 500, layer, exception);
        }
    }
}
