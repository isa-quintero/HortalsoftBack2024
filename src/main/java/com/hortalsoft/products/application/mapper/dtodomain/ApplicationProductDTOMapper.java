package com.hortalsoft.products.application.mapper.dtodomain;

import com.hortalsoft.crosscutting.response.ApplicationDTOMapper;
import com.hortalsoft.products.application.dto.ProductDTO;
import com.hortalsoft.products.domain.domain.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ApplicationProductDTOMapper extends ApplicationDTOMapper<ProductDTO, Product> {
}
