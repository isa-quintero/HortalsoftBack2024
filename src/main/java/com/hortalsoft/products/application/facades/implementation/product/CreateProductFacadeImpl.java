package com.hortalsoft.products.application.facades.implementation.product;

import com.hortalsoft.products.application.dto.ProductDTO;
import com.hortalsoft.products.application.facades.facade.product.CreateProductFacade;
import com.hortalsoft.products.domain.domain.Product;
import com.hortalsoft.products.domain.port.input.product.CreateProductUseCase;
import com.hortalsoft.products.application.mapper.MapperDTOToDomain;
import com.hortalsoft.crosscutting.util.ExceptionHandlingAspect;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CreateProductFacadeImpl implements CreateProductFacade {

    MapperDTOToDomain<ProductDTO, Product> mapperDTOToDomain = new MapperDTOToDomain<>();
    private final CreateProductUseCase useCaseCreate;
    private final ExceptionHandlingAspect exceptionHandlingAspect;

    public CreateProductFacadeImpl(CreateProductUseCase useCase, ExceptionHandlingAspect exceptionHandlingAspect) {
        this.useCaseCreate = useCase;
        this.exceptionHandlingAspect = exceptionHandlingAspect;
    }

    /**
     * Executes the CreateProductFacadeImpl by mapping the given ProductDTO to a Product domain object
     * and invoking the execute method of the CreateProductUseCase with the domain object as a parameter.
     *
     * @param dto The ProductDTO object containing the data to be mapped to the domain object.
     */
    @Override
    public void execute(ProductDTO dto) {
        try {
            Product domain = mapperDTOToDomain.mapToDomain(dto, Product.class);
            useCaseCreate.execute(domain);
        } catch (Exception exception) {
            exceptionHandlingAspect.exceptionsApplication(exception);
        }
    }
}
