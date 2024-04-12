package com.hortalsoft.products.application.mapper.entitydomain;

import com.hortalsoft.crosscutting.response.ApplicationEntityMapper;
import com.hortalsoft.products.domain.domain.Subcategory;
import com.hortalsoft.products.domain.entity.SubcategoryEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ApplicationSubcategoryEntityMapper extends ApplicationEntityMapper<SubcategoryEntity, Subcategory> {
}
