package com.hortalsoft.products.application.facades.implementation.product;

import com.hortalsoft.products.application.dto.ProductDTO;
import com.hortalsoft.products.application.facades.facade.product.CreateProductFacade;
import com.hortalsoft.products.domain.domain.Product;
import com.hortalsoft.products.domain.port.input.product.CreateProductUseCase;
import com.hortalsoft.products.application.mapper.MapperDTOToDomain;
import com.hortalsoft.products.util.ExceptionHandlingAspect;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class CreateProductFacadeImpl implements CreateProductFacade {

    MapperDTOToDomain<ProductDTO ,Product> mapperDTOToDomain = new MapperDTOToDomain<>();
    private final CreateProductUseCase useCaseCreate;
    private final ExceptionHandlingAspect exceptionHandlingAspect;



    public CreateProductFacadeImpl(CreateProductUseCase useCase, ExceptionHandlingAspect exceptionHandlingAspect) {
        this.useCaseCreate = useCase;
        this.exceptionHandlingAspect = exceptionHandlingAspect;
    }

    @Override
    public void execute(ProductDTO dto) {
        try{
            Product domain = mapperDTOToDomain.mapToDomain(dto, Product.class);
            useCaseCreate.execute(domain);
        }
        catch(Exception e){
            exceptionHandlingAspect.exceptionsApplication(e);
        }
    }
}
