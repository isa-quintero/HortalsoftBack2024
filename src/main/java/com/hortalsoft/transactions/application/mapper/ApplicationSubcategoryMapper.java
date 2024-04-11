package com.hortalsoft.transactions.application.mapper;

import com.hortalsoft.transactions.application.dto.SubcategoryDTO;
import com.hortalsoft.transactions.domain.domain.Subcategory;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface ApplicationSubcategoryMapper extends ApplicationEntityMapper<SubcategoryDTO, Subcategory> {
}
