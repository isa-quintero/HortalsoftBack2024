package com.hortalsoft.products.application.implementation.subcategory;


import com.hortalsoft.products.application.dto.SubcategoryDTO;
import com.hortalsoft.products.application.facade.subcategory.FindSubcategoryFacade;
import com.hortalsoft.products.domain.domain.Subcategory;
import com.hortalsoft.products.domain.repository.SubcategoryRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class FindSubcategoryFacadeImpl implements FindSubcategoryFacade {
    private final SubcategoryRepository subcategoryRepository;

    public FindSubcategoryFacadeImpl(SubcategoryRepository subcategoryRepository) {
        this.subcategoryRepository = subcategoryRepository;
    }


    @Override
    public SubcategoryDTO execute(SubcategoryDTO dto) {
        return null;
    }
}
