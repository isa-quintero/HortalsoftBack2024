package com.hortalsoft.products.application.facades.implementation.product;


import com.hortalsoft.products.application.dto.ProductDTO;
import com.hortalsoft.products.application.facades.facade.product.ListProductsFacade;
import com.hortalsoft.products.domain.domain.Product;
import com.hortalsoft.products.domain.port.input.product.ListProductsUseCase;
import com.hortalsoft.products.application.mapper.MapperDomainToDto;
import com.hortalsoft.products.util.ExceptionHortalsoft;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ListProductsFacadeImpl implements ListProductsFacade {
    MapperDomainToDto<Product, ProductDTO> mapperDomainToDto = new MapperDomainToDto<>();
    private final ListProductsUseCase useCase;

    public ListProductsFacadeImpl(ListProductsUseCase useCase) {
        this.useCase = useCase;
    }
    @Override
    public List<ProductDTO> execute() {
        try{
            return mapperDomainToDto.mapToDtoList(useCase.execute(),ProductDTO.class);
        }catch(Exception e){
            if (e instanceof ExceptionHortalsoft){
                throw (ExceptionHortalsoft) e;
            }else{
                throw new ExceptionHortalsoft(e.getMessage(),500,"Application");
            }
        }
    }
}
