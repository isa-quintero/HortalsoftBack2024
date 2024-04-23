package com.hortalsoft.products.application.implementation.product;

import com.hortalsoft.products.application.dto.OfferDTO;
import com.hortalsoft.products.application.dto.ProductDTO;
import com.hortalsoft.products.application.facade.product.CreateProductFacade;
import com.hortalsoft.products.domain.domain.Offer;
import com.hortalsoft.products.domain.domain.Product;
import com.hortalsoft.products.domain.port.product.CreateProductUseCase;
import com.hortalsoft.products.util.mapper.MapperDTOToDomain;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionSystemException;


@Service
@Transactional
public class CreateProductFacadeImpl implements CreateProductFacade {

    MapperDTOToDomain<ProductDTO ,Product> mapperDTOToDomain = new MapperDTOToDomain();
    MapperDTOToDomain<OfferDTO,Offer> mapperDTOsToDomains = new MapperDTOToDomain();
    private final CreateProductUseCase useCase;

    public CreateProductFacadeImpl(CreateProductUseCase useCase) {
        this.useCase = useCase;
    }

    @Override
    public void execute(ProductDTO dto) {
        try{
            Product domain = mapperDTOToDomain.mapToDomain(dto, Product.class);
            useCase.execute(domain);
        }
        catch(Exception e){
            throw new TransactionSystemException(e.getMessage());
        }
    }
}
