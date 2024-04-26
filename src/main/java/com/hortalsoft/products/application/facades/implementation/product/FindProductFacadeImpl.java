package com.hortalsoft.products.application.facades.implementation.product;


import com.hortalsoft.products.application.dto.ProductDTO;
import com.hortalsoft.products.application.facades.facade.product.FindProductFacade;
import com.hortalsoft.products.domain.domain.Product;
import com.hortalsoft.products.domain.entity.ProductEntity;
import com.hortalsoft.products.domain.port.input.product.FindProductUseCase;
import com.hortalsoft.products.application.mapper.MapperDTOToDomain;
import com.hortalsoft.products.application.mapper.MapperDomainToDto;
import com.hortalsoft.products.domain.mapper.MapperEntityToDomain;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class FindProductFacadeImpl implements FindProductFacade {

    MapperDTOToDomain<ProductDTO, Product> mapperDTOToDomain = new MapperDTOToDomain<>();
    MapperDomainToDto<Product, ProductDTO> mapperDomainToDto = new MapperDomainToDto<>();
    MapperEntityToDomain<ProductEntity,Product> mapperEntityToDomain = new MapperEntityToDomain<>();
    private final FindProductUseCase useCase;

    public FindProductFacadeImpl(FindProductUseCase useCase) {
        this.useCase = useCase;
    }

    @Override
    public ProductDTO execute(ProductDTO dto) {
        Product domain = mapperDTOToDomain.mapToDomain(dto,Product.class);
        return mapperDomainToDto.mapToDto(useCase.execute(domain),ProductDTO.class);
    }
}
