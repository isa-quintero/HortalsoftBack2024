package com.hortalsoft.products.application.mapper.entitydomain;


import com.hortalsoft.crosscutting.response.ApplicationEntityMapper;
import com.hortalsoft.products.domain.domain.Product;
import com.hortalsoft.products.domain.entity.ProductEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ApplicationProductEntityMapper extends ApplicationEntityMapper<ProductEntity, Product> {
}
