package com.hortalsoft.products.application.facade.category;

//import com.hortalsoft.crosscutting.response.usecase.facade.UseCaseFindFacade;
import com.hortalsoft.products.util.usecase.facade.UseCaseFindFacade;
import com.hortalsoft.products.application.dto.CategoryDTO;
import com.hortalsoft.products.domain.domain.Category;

public interface FindCategoryFacade extends UseCaseFindFacade<CategoryDTO,Category> {
}
