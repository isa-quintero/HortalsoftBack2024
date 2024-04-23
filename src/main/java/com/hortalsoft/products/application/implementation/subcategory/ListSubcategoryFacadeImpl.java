package com.hortalsoft.products.application.implementation.subcategory;


import com.hortalsoft.products.application.dto.SubcategoryDTO;
import com.hortalsoft.products.application.facade.subcategory.ListSubcategoryFacade;

import java.util.List;
import java.util.Optional;

public class ListSubcategoryFacadeImpl implements ListSubcategoryFacade {
    @Override
    public List<SubcategoryDTO> execute(Optional<SubcategoryDTO> dto) {
        return List.of();
    }
}
