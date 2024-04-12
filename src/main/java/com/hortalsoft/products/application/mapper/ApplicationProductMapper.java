package com.hortalsoft.products.application.mapper;

import com.hortalsoft.crosscutting.response.ApplicationEntityMapper;
import com.hortalsoft.products.application.dto.ProductDTO;
import com.hortalsoft.products.domain.domain.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface ApplicationProductMapper extends ApplicationEntityMapper<ProductDTO, Product> {
}
