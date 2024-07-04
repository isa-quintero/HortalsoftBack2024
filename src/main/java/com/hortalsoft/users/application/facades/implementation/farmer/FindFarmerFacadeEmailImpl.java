package com.hortalsoft.users.application.facades.implementation.farmer;

import com.hortalsoft.crosscutting.util.ExceptionHortalsoft;
import com.hortalsoft.crosscutting.util.Layer;
import com.hortalsoft.users.application.dto.FarmerDTO;
import com.hortalsoft.users.application.facades.facade.farmer.FindFarmerFacadeEmail;
import com.hortalsoft.users.application.mapper.MapperDTOToDomain;
import com.hortalsoft.users.application.mapper.MapperDomainToDto;
import com.hortalsoft.users.domain.domain.Farmer;
import com.hortalsoft.users.domain.port.input.farmer.FindFarmerEmailUseCase;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class FindFarmerFacadeEmailImpl implements FindFarmerFacadeEmail {
    MapperDTOToDomain<FarmerDTO, Farmer> mapperDTOToDomain = new MapperDTOToDomain<>();
    MapperDomainToDto<Farmer, FarmerDTO> mapperDomainToDto = new MapperDomainToDto<>();
    private final FindFarmerEmailUseCase useCase;
    private static final Layer layer = Layer.APPLICATION;

    public FindFarmerFacadeEmailImpl(FindFarmerEmailUseCase useCase) {
        this.useCase = useCase;
    }

    @Override
    public FarmerDTO execute(FarmerDTO dto) {
        try {
            Farmer domain = mapperDTOToDomain.mapToDomain(dto, Farmer.class);
            return mapperDomainToDto.mapToDto(useCase.execute(domain), FarmerDTO.class);
        } catch (ExceptionHortalsoft exceptionHortalsoft) {
            throw exceptionHortalsoft;
        } catch (Exception exception) {
            throw new ExceptionHortalsoft("Ha ocurrido un error inesperado", 500, layer, exception);
        }
    }
}
