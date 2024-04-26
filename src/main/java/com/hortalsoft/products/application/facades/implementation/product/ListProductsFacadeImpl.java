package com.hortalsoft.products.application.facades.implementation.product;


import com.hortalsoft.products.application.dto.ProductDTO;
import com.hortalsoft.products.application.facades.facade.product.ListProductsFacade;
import com.hortalsoft.products.domain.domain.Product;
import com.hortalsoft.products.domain.entity.ProductEntity;
import com.hortalsoft.products.domain.port.input.product.ListProductsUseCase;
import com.hortalsoft.products.application.mapper.MapperDTOToDomain;
import com.hortalsoft.products.application.mapper.MapperDomainToDto;
import com.hortalsoft.products.domain.mapper.MapperEntityToDomain;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ListProductsFacadeImpl implements ListProductsFacade {
    MapperDTOToDomain<ProductDTO, Product> mapperDTOToDomain = new MapperDTOToDomain<>();
    MapperDomainToDto<Product, ProductDTO> mapperDomainToDto = new MapperDomainToDto<>();
    MapperEntityToDomain<ProductEntity,Product> mapperEntityToDomain = new MapperEntityToDomain<>();
    private final ListProductsUseCase useCase;

    public ListProductsFacadeImpl(ListProductsUseCase useCase) {
        this.useCase = useCase;
    }
    @Override
    public List<ProductDTO> execute() {
        List<ProductDTO> productDTOS=mapperDomainToDto.mapToDtoList(useCase.execute(),ProductDTO.class);
        return productDTOS;
    }
}
