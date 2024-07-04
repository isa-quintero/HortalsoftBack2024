package com.hortalsoft.users.application.facades.implementation.farmer;

import com.hortalsoft.crosscutting.util.ExceptionHandlingAspect;
import com.hortalsoft.users.application.dto.FarmerDTO;
import com.hortalsoft.users.application.facades.facade.farmer.CreateFarmerFacade;
import com.hortalsoft.users.application.mapper.MapperDTOToDomain;
import com.hortalsoft.users.domain.domain.Farmer;
import com.hortalsoft.users.domain.port.input.farmer.CreateFarmerUseCase;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CreateFarmerFacadeImpl implements CreateFarmerFacade {

    MapperDTOToDomain<FarmerDTO, Farmer> mapperDTOToDomain = new MapperDTOToDomain<>();

    private final CreateFarmerUseCase createFarmerUseCase;
    private final ExceptionHandlingAspect exceptionHandlingAspect;

    public CreateFarmerFacadeImpl(CreateFarmerUseCase createFarmerUseCase, ExceptionHandlingAspect exceptionHandlingAspect) {
        this.createFarmerUseCase = createFarmerUseCase;
        this.exceptionHandlingAspect = exceptionHandlingAspect;
    }


    @Override
    public void execute(FarmerDTO dto) {
        try {
            Farmer domain = mapperDTOToDomain.mapToDomain(dto, Farmer.class);
            createFarmerUseCase.execute(domain);
        } catch (Exception exception) {
            exceptionHandlingAspect.exceptionsApplication(exception);
        }
    }


}
