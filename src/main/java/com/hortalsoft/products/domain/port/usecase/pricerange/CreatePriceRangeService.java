package com.hortalsoft.products.domain.port.usecase.pricerange;


import com.hortalsoft.products.domain.domain.PriceRange;
import com.hortalsoft.products.domain.entity.PriceRangeEntity;
import com.hortalsoft.products.domain.port.input.pricerange.CreatePriceRangeUseCase;
import com.hortalsoft.products.domain.repository.PriceRangeRepository;
import com.hortalsoft.products.domain.mapper.MapperDomainToEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionSystemException;


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

            //TODO implementar validaciones para creación de price range
            PriceRangeEntity entity =  mapperDomainToEntity.mapToEntity(domain,PriceRangeEntity.class);
            if (!priceRangeRepository.existsById(entity.getId())){
                priceRangeRepository.save(entity);
            }
            else{
                System.out.println("El rango de precios ya existe en el sistema");
            }
        }
        catch(Exception e){
            throw new TransactionSystemException(e.getMessage());
        }
    }
}