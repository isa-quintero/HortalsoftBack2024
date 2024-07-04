package com.hortalsoft.users.application.facades.implementation.farmer;

import com.hortalsoft.crosscutting.util.ExceptionHandlingAspect;
import com.hortalsoft.users.application.dto.FarmerDTO;
import com.hortalsoft.users.application.facades.facade.farmer.DeleteFarmerFacade;
import com.hortalsoft.users.application.mapper.MapperDTOToDomain;
import com.hortalsoft.users.domain.domain.Farmer;
import com.hortalsoft.users.domain.port.input.farmer.DeleteFarmerUseCase;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class DeleteFarmerFacadeImpl implements DeleteFarmerFacade {
    MapperDTOToDomain<FarmerDTO, Farmer> mapperDTOToDomain = new MapperDTOToDomain<>();
    private final DeleteFarmerUseCase useCase;
    private final ExceptionHandlingAspect exceptionHandlingAspect;

    public DeleteFarmerFacadeImpl(DeleteFarmerUseCase useCase, ExceptionHandlingAspect exceptionHandlingAspect) {
        this.useCase = useCase;

        this.exceptionHandlingAspect = exceptionHandlingAspect;
    }

    @Override
    public void execute(FarmerDTO dto) {
        try {
            Farmer domain = mapperDTOToDomain.mapToDomain(dto, Farmer.class);
            useCase.execute(domain);
        } catch (Exception exception) {
            exceptionHandlingAspect.exceptionsApplication(exception);
        }
    }
}
