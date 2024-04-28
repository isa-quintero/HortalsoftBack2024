package com.hortalsoft.products.application.facades.implementation.product;


import com.hortalsoft.products.application.dto.ProductDTO;
import com.hortalsoft.products.application.facades.facade.product.DeleteProductFacade;
import com.hortalsoft.products.domain.domain.Product;
import com.hortalsoft.products.domain.port.input.product.DeleteProductUseCase;
import com.hortalsoft.products.application.mapper.MapperDTOToDomain;
import com.hortalsoft.products.util.ExceptionHandlingAspect;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class DeleteProductFacadeImpl implements DeleteProductFacade {
    MapperDTOToDomain<ProductDTO ,Product> mapperDTOToDomain = new MapperDTOToDomain<>();
    private final DeleteProductUseCase useCase;
    private final ExceptionHandlingAspect exceptionHandlingAspect;


    public DeleteProductFacadeImpl(DeleteProductUseCase useCase, ExceptionHandlingAspect exceptionHandlingAspect) {
        this.useCase = useCase;

        this.exceptionHandlingAspect = exceptionHandlingAspect;
    }
    @Override
    public void execute(ProductDTO dto) {
        try{
            Product domain = mapperDTOToDomain.mapToDomain(dto, Product.class);
            useCase.execute(domain);
        }catch(Exception e){
            exceptionHandlingAspect.exceptionsApplication(e);
        }
    }
}
