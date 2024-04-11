package com.hortalsoft.transactions.application.mapper;

import com.hortalsoft.transactions.application.dto.CategoryDTO;
import com.hortalsoft.transactions.domain.domain.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface ApplicationCategoryMapper extends ApplicationEntityMapper<CategoryDTO, Category> {
}
