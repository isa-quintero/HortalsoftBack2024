package com.hortalsoft.products.domain.port.usecase.pricerange;


import com.hortalsoft.products.domain.domain.PriceRange;
import com.hortalsoft.products.domain.entity.PriceRangeEntity;
import com.hortalsoft.products.domain.port.input.pricerange.CreatePriceRangeUseCase;
import com.hortalsoft.products.domain.repository.PriceRangeRepository;
import com.hortalsoft.products.domain.mapper.MapperDomainToEntity;
import com.hortalsoft.products.util.ExceptionHortalsoft;
import com.hortalsoft.products.util.Layers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CreatePriceRangeService implements CreatePriceRangeUseCase {

    private final PriceRangeRepository priceRangeRepository;
    MapperDomainToEntity<PriceRange, PriceRangeEntity> mapperDomainToEntity = new MapperDomainToEntity<>();


    @Autowired
    public CreatePriceRangeService(PriceRangeRepository priceRangeRepository) {
        this.priceRangeRepository = priceRangeRepository;

    }

    @Override
    public void execute(PriceRange domain) {
        try{


            PriceRangeEntity entity =  mapperDomainToEntity.mapToEntity(domain,PriceRangeEntity.class);
            if (!priceRangeRepository.existsById(entity.getId())){
                if (!priceRangeRepository.existsByAssociationIdAndInitialDateAndProductId(entity.getAssociationId(),entity.getInitialDate(),entity.getProduct().getId())){
                    priceRangeRepository.save(entity);
                }
                else{
                    throw  new ExceptionHortalsoft("El rango de precios ya existe", 5001, Layers.DOMAIN);
                }
            }
            else{
                throw  new ExceptionHortalsoft("El rango de precios ya existe", 5001, Layers.DOMAIN);
            }
        }
        catch(Exception e){
            if (e instanceof ExceptionHortalsoft){
                throw (ExceptionHortalsoft) e;
            }else{
                throw new ExceptionHortalsoft(e.getMessage(),500,Layers.DOMAIN);
            }
        }
    }
}
