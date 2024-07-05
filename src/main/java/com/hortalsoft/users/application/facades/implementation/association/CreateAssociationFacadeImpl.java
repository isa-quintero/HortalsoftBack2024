package com.hortalsoft.users.application.facades.implementation.association;

import com.hortalsoft.crosscutting.util.ExceptionHandlingAspect;
import com.hortalsoft.users.application.dto.AssociationDTO;
import com.hortalsoft.users.application.facades.facade.association.CreateAssociationFacade;
import com.hortalsoft.users.application.mapper.MapperDTOToDomain;
import com.hortalsoft.users.domain.domain.Association;
import com.hortalsoft.users.domain.port.input.association.CreateAssociationUseCase;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CreateAssociationFacadeImpl implements CreateAssociationFacade {

    MapperDTOToDomain<AssociationDTO, Association> mapperDTOToDomain = new MapperDTOToDomain<>();

    private final CreateAssociationUseCase createAssociationUseCase;
    private final ExceptionHandlingAspect exceptionHandlingAspect;

    public CreateAssociationFacadeImpl(CreateAssociationUseCase createAssociationUseCase, ExceptionHandlingAspect exceptionHandlingAspect) {
        this.createAssociationUseCase = createAssociationUseCase;
        this.exceptionHandlingAspect = exceptionHandlingAspect;
    }


    @Override
    public void execute(AssociationDTO dto) {
        try {
            Association domain = mapperDTOToDomain.mapToDomain(dto, Association.class);
            createAssociationUseCase.execute(domain);
        } catch (Exception exception) {
            exceptionHandlingAspect.exceptionsApplication(exception);
        }
    }


}
