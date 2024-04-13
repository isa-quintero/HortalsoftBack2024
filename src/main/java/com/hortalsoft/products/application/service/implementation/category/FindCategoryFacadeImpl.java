package com.hortalsoft.products.application.service.implementation.category;


import com.hortalsoft.products.application.dto.CategoryDTO;
import com.hortalsoft.products.application.service.facade.category.FindCategoryFacade;

import com.hortalsoft.products.domain.domain.Category;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class FindCategoryFacadeImpl implements FindCategoryFacade {
    @Override
    public Category execute(CategoryDTO dto) {
        return null;
    }
}
