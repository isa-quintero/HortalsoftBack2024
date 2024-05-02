package com.hortalsoft.products.domain.port.usecase.pricerange;


import com.hortalsoft.products.domain.domain.PriceRange;
import com.hortalsoft.products.domain.port.input.pricerange.DeletePriceRangeUseCase;
import com.hortalsoft.products.domain.repository.PriceRangeRepository;
import com.hortalsoft.products.util.ExceptionHortalsoft;
import com.hortalsoft.products.util.Layers;
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
                throw new ExceptionHortalsoft("El rnago de precios no existe",6001, Layers.DOMAIN);
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
