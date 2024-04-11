package com.hortalsoft.users.application.mapper;

import com.hortalsoft.users.application.dto.SubcategoryDTO;
import com.hortalsoft.users.domain.domain.Subcategory;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface ApplicationSubcategoryMapper extends ApplicationEntityMapper<SubcategoryDTO, Subcategory> {
}
