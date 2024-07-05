package com.hortalsoft.users.application.facades.implementation.association;

import com.hortalsoft.crosscutting.util.ExceptionHandlingAspect;
import com.hortalsoft.users.application.dto.AssociationDTO;
import com.hortalsoft.users.application.facades.facade.association.DeleteAssociationFacade;
import com.hortalsoft.users.application.mapper.MapperDTOToDomain;
import com.hortalsoft.users.domain.domain.Association;
import com.hortalsoft.users.domain.port.input.association.DeleteAssociationUseCase;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class DeleteAssociationFacadeImpl implements DeleteAssociationFacade {
    MapperDTOToDomain<AssociationDTO, Association> mapperDTOToDomain = new MapperDTOToDomain<>();
    private final DeleteAssociationUseCase useCase;
    private final ExceptionHandlingAspect exceptionHandlingAspect;

    public DeleteAssociationFacadeImpl(DeleteAssociationUseCase useCase, ExceptionHandlingAspect exceptionHandlingAspect) {
        this.useCase = useCase;

        this.exceptionHandlingAspect = exceptionHandlingAspect;
    }

    @Override
    public void execute(AssociationDTO dto) {
        try {
            Association domain = mapperDTOToDomain.mapToDomain(dto, Association.class);
            useCase.execute(domain);
        } catch (Exception exception) {
            exceptionHandlingAspect.exceptionsApplication(exception);
        }
    }
}
