package com.hortalsoft.products.domain.port.usecase.pricerange;


import com.hortalsoft.products.domain.domain.PriceRange;
import com.hortalsoft.products.domain.port.input.pricerange.DeletePriceRangeUseCase;
import com.hortalsoft.products.domain.repository.PriceRangeRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionSystemException;


@Service
@Transactional
public class DeletePriceRangeService implements DeletePriceRangeUseCase {

    private final PriceRangeRepository priceRangeRepository;
    private static final Logger logger = LoggerFactory.getLogger(DeletePriceRangeService.class);



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
                logger.error("El producto no existe");
            }
        }
        catch(Exception e){
            throw new TransactionSystemException(e.getMessage());
        }
    }
}