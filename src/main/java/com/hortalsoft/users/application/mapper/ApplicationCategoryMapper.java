package com.hortalsoft.users.application.mapper;

import com.hortalsoft.users.application.dto.CategoryDTO;
import com.hortalsoft.users.domain.domain.Association;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface ApplicationCategoryMapper extends ApplicationEntityMapper<CategoryDTO, Association> {
}
