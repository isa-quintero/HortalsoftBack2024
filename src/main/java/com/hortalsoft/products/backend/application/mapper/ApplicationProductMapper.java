package com.hortalsoft.products.backend.application.mapper;

import com.hortalsoft.products.backend.application.dto.ProductDTO;
import com.hortalsoft.products.backend.domain.domain.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface ApplicationProductMapper extends ApplicationEntityMapper<ProductDTO, Product> {

}