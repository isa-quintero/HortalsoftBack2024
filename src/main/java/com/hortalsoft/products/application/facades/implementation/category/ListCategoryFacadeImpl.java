package com.hortalsoft.products.application.facades.implementation.category;


import com.hortalsoft.products.application.dto.CategoryDTO;
import com.hortalsoft.products.application.facades.facade.category.ListCategoryFacade;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ListCategoryFacadeImpl implements ListCategoryFacade {
    @Override
    public List<CategoryDTO> execute() {
        return List.of();
    }
}
