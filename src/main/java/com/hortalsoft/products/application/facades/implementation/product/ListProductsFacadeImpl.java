package com.hortalsoft.products.application.facades.implementation.product;


import com.hortalsoft.products.application.dto.ProductDTO;
import com.hortalsoft.products.application.facades.facade.product.ListProductsFacade;
import com.hortalsoft.products.domain.domain.Product;
import com.hortalsoft.products.domain.port.input.product.ListProductsUseCase;
import com.hortalsoft.products.application.mapper.MapperDomainToDto;
import com.hortalsoft.util.ExceptionHortalsoft;
import com.hortalsoft.util.Layers;
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
        }catch(ExceptionHortalsoft e){
            throw e;
        }catch(Exception e){
            throw new ExceptionHortalsoft(e.getMessage(),500, Layers.APPLICATION, e);
        }
    }
}
