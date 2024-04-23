package com.hortalsoft.products.application.implementation.product;


import com.hortalsoft.products.application.dto.ProductDTO;
import com.hortalsoft.products.application.facade.product.FindProductFacade;
import com.hortalsoft.products.domain.domain.Product;
import com.hortalsoft.products.domain.entity.ProductEntity;
import com.hortalsoft.products.domain.port.product.FindProductUseCase;
import com.hortalsoft.products.util.mapper.MapperDTOToDomain;
import com.hortalsoft.products.util.mapper.MapperDomainToDto;
import com.hortalsoft.products.util.mapper.MapperEntityToDomain;
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
    public Product execute(ProductDTO dto) {
        Product domain = mapperDTOToDomain.mapToDomain(dto,Product.class);
        Product product = mapperEntityToDomain.mapToDomain(useCase.execute(domain),Product.class);
        return product;
    }
}
