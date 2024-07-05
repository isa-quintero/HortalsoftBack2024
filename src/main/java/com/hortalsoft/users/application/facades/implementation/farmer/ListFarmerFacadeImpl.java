package com.hortalsoft.users.application.facades.implementation.farmer;

import com.hortalsoft.crosscutting.util.ExceptionHortalsoft;
import com.hortalsoft.crosscutting.util.Layer;
import com.hortalsoft.users.application.dto.FarmerDTO;
import com.hortalsoft.users.application.facades.facade.farmer.ListFarmerFacade;
import com.hortalsoft.users.application.mapper.MapperDomainToDto;
import com.hortalsoft.users.domain.domain.Farmer;
import com.hortalsoft.users.domain.port.input.farmer.ListFarmerUseCase;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ListFarmerFacadeImpl implements ListFarmerFacade {

    MapperDomainToDto<Farmer, FarmerDTO> mapperDomainToDto = new MapperDomainToDto<>();
    private final ListFarmerUseCase useCase;
    private static final Layer layer = Layer.APPLICATION;

    public ListFarmerFacadeImpl(ListFarmerUseCase useCase) {
        this.useCase = useCase;
    }

    @Override
    public List<FarmerDTO> execute() {
        try {
            return mapperDomainToDto.mapToDtoList(useCase.execute(), FarmerDTO.class);
        } catch (ExceptionHortalsoft exceptionHortalsoft) {
            throw exceptionHortalsoft;
        } catch (Exception exception) {
            throw new ExceptionHortalsoft("Ha ocurrido un error inesperado", 500, layer, exception);
        }
    }
}
