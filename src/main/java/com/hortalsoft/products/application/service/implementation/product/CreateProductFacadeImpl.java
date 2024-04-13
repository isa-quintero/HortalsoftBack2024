package com.hortalsoft.products.application.service.implementation.product;

import com.hortalsoft.products.application.dto.ProductDTO;
import com.hortalsoft.products.application.service.facade.product.CreateProductFacade;
import com.hortalsoft.products.domain.domain.Product;
import com.hortalsoft.products.domain.entity.ProductEntity;
import com.hortalsoft.products.domain.repository.ProductRepository;
import com.hortalsoft.products.util.mapper.MapperDTOToDomain;
import com.hortalsoft.products.util.mapper.MapperDomainToDto;
import com.hortalsoft.products.util.mapper.MapperDomainToEntity;
import com.hortalsoft.products.util.mapper.MapperEntityToDomain;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CreateProductFacadeImpl implements CreateProductFacade {

    private final ProductRepository productRepository;
    MapperDTOToDomain<ProductDTO,Product> mapperDTOToDomain = new MapperDTOToDomain();
    MapperDomainToDto<Product,ProductDTO> mapperDomainToDTO = new MapperDomainToDto();
    MapperDomainToEntity<Product,ProductEntity> mapperDomainToEntity = new MapperDomainToEntity();
    MapperEntityToDomain<ProductEntity,Product> mapperEntityToDomain = new MapperEntityToDomain();


    @Autowired
    public CreateProductFacadeImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;

    }

    @Override
    public ProductDTO execute(ProductDTO dto) {
        Product domain = mapperDTOToDomain.mapToDomain(dto, Product.class);
        ProductEntity entity =  mapperDomainToEntity.mapToEntity(domain,ProductEntity.class);
        Product entityDomain=  mapperEntityToDomain.mapToDomain(productRepository.save(entity),Product.class);
        return (ProductDTO) mapperDomainToDTO.mapToDto(entityDomain,ProductDTO.class);
    }
}
