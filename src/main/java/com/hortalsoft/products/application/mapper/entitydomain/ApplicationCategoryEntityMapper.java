package com.hortalsoft.products.application.mapper.entitydomain;

import com.hortalsoft.crosscutting.response.ApplicationEntityMapper;
import com.hortalsoft.products.domain.domain.Category;
import com.hortalsoft.products.domain.entity.CategoryEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ApplicationCategoryEntityMapper extends ApplicationEntityMapper<CategoryEntity, Category> {
}
