package com.hortalsoft.products.application.mapper.dtodomain;

import com.hortalsoft.products.util.ApplicationDTOMapper;
import com.hortalsoft.products.application.dto.ProductDTO;
import com.hortalsoft.products.domain.domain.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",uses = {})
public interface ApplicationProductDTOMapper extends ApplicationDTOMapper<ProductDTO, Product> {
}
