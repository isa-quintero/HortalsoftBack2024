package com.hortalsoft.products.domain.port.usecase.pricerange;


import com.hortalsoft.products.domain.domain.PriceRange;
import com.hortalsoft.products.domain.port.input.pricerange.DeletePriceRangeUseCase;
import com.hortalsoft.products.domain.repository.PriceRangeRepository;
import com.hortalsoft.products.util.ExceptionHortalsoft;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class DeletePriceRangeService implements DeletePriceRangeUseCase {

    private final PriceRangeRepository priceRangeRepository;



    @Autowired
    public DeletePriceRangeService(PriceRangeRepository priceRangeRepository) {
        this.priceRangeRepository = priceRangeRepository;

    }

    @Override
    public void execute(PriceRange domain) {
        try{
            if(priceRangeRepository.existsById(domain.getId())){
                priceRangeRepository.deleteById(domain.getId());
            }
            else{
                throw new ExceptionHortalsoft("El rnago de precios no existe",6001);
            }
        }
        catch(ExceptionHortalsoft e){
            throw e;
        }
    }
}
