package com.hortalsoft.products.application.service.facade.subcategory;


//import com.hortalsoft.crosscutting.response.usecase.facade.UseCaseFindFacade;
import com.hortalsoft.products.util.usecase.facade.UseCaseFindFacade;
import com.hortalsoft.products.application.dto.SubcategoryDTO;
import com.hortalsoft.products.domain.domain.Subcategory;

public interface FindSubcategoryFacade extends UseCaseFindFacade<SubcategoryDTO, Subcategory> {
}
