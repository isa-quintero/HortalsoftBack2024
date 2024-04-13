package com.hortalsoft.products.domain.port.category;

import com.hortalsoft.crosscutting.response.usecase.domain.UseCaseFindDomain;
import com.hortalsoft.products.domain.domain.Category;
import com.hortalsoft.products.domain.entity.CategoryEntity;

public interface FindCategoryUseCase extends UseCaseFindDomain<Category, CategoryEntity> {
}
