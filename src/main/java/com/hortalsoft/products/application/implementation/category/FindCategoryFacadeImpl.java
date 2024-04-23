package com.hortalsoft.products.application.implementation.category;


import com.hortalsoft.products.application.dto.CategoryDTO;
import com.hortalsoft.products.application.facade.category.FindCategoryFacade;

import com.hortalsoft.products.domain.domain.Category;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class FindCategoryFacadeImpl implements FindCategoryFacade {
    @Override
    public CategoryDTO execute(CategoryDTO dto) {
        return null;
    }
}
