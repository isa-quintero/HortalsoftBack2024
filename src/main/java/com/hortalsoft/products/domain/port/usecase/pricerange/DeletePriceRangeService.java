package com.hortalsoft.products.domain.port.usecase.pricerange;


import com.hortalsoft.products.domain.domain.PriceRange;
import com.hortalsoft.products.domain.entity.PriceRangeEntity;
import com.hortalsoft.products.domain.mapper.MapperDomainToEntity;
import com.hortalsoft.products.domain.port.input.pricerange.DeletePriceRangeUseCase;
import com.hortalsoft.products.domain.repository.PriceRangeRepository;
import com.hortalsoft.crosscutting.util.ExceptionHortalsoft;
import com.hortalsoft.crosscutting.util.Layer;
import com.hortalsoft.products.domain.specification.implementation.pricerange.PriceRangeExistsByIdSpec;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class DeletePriceRangeService implements DeletePriceRangeUseCase {

    private static final Layer layer = Layer.DOMAIN;
    private final PriceRangeRepository priceRangeRepository;
    MapperDomainToEntity<PriceRange, PriceRangeEntity> mapperDomainToEntity = new MapperDomainToEntity<>();


    @Autowired
    public DeletePriceRangeService(PriceRangeRepository priceRangeRepository) {
        this.priceRangeRepository = priceRangeRepository;
    }

    @Override
    public void execute(PriceRange domain) {
        try {
            PriceRangeExistsByIdSpec priceRangeExistsByIdSpec = new PriceRangeExistsByIdSpec(priceRangeRepository);
            PriceRangeEntity entity = mapperDomainToEntity.mapToEntity(domain, PriceRangeEntity.class);
            if (priceRangeExistsByIdSpec.isSatisfiedBy(entity)) {
                priceRangeRepository.deleteById(domain.getIdPriceRange());
            } else {
                throw new ExceptionHortalsoft("El rango de precios no existe", 6001, layer);
            }
        } catch (ExceptionHortalsoft exceptionHortalsoft) {
            throw exceptionHortalsoft;
        } catch (Exception exception) {
            throw new ExceptionHortalsoft("Ha ocurrido un error inesperado eliminando el rango de precios", 500, layer, exception);
        }
    }
}
