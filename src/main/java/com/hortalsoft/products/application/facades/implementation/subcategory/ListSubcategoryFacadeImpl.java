package com.hortalsoft.products.application.facades.implementation.subcategory;


import com.hortalsoft.products.application.dto.SubcategoryDTO;
import com.hortalsoft.products.application.facades.facade.subcategory.ListSubcategoryFacade;
import com.hortalsoft.products.application.mapper.MapperDomainToDto;
import com.hortalsoft.products.domain.domain.Subcategory;
import com.hortalsoft.products.domain.port.input.subcategory.ListSubcategoryUseCase;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ListSubcategoryFacadeImpl implements ListSubcategoryFacade {

    MapperDomainToDto<Subcategory, SubcategoryDTO> mapperDomainToDto = new MapperDomainToDto<>();
    private final ListSubcategoryUseCase useCase;

    public ListSubcategoryFacadeImpl(ListSubcategoryUseCase useCase) {
        this.useCase = useCase;
    }

    @Override
    public List<SubcategoryDTO> execute() {
        return mapperDomainToDto.mapToDtoList(useCase.execute(), SubcategoryDTO.class);
    }
}