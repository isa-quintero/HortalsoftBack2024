package com.hortalsoft.users.application.facades.implementation;

import com.hortalsoft.crosscutting.util.ExceptionHortalsoft;
import com.hortalsoft.crosscutting.util.Layer;
import com.hortalsoft.users.application.dto.UserDTO;
import com.hortalsoft.users.application.facades.facade.user.ListUserFacade;
import com.hortalsoft.users.application.mapper.MapperDTOToDomain;
import com.hortalsoft.users.application.mapper.MapperDomainToDto;
import com.hortalsoft.users.domain.domain.User;
import com.hortalsoft.users.domain.port.input.user.ListUserUseCase;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ListUserFacadeImpl implements ListUserFacade {

    MapperDomainToDto<User, UserDTO> mapperDomainToDto = new MapperDomainToDto<>();
    MapperDTOToDomain<UserDTO, User> mapperDTOToDomain = new MapperDTOToDomain<>();
    private final ListUserUseCase useCase;
    private static final Layer layer = Layer.APPLICATION;

    public ListUserFacadeImpl(ListUserUseCase useCase) {
        this.useCase = useCase;
    }

    @Override
    public List<UserDTO> execute(UserDTO dto) {
        try {
            User domain = mapperDTOToDomain.mapToDomain(dto, User.class);
            return mapperDomainToDto.mapToDtoList(useCase.execute(), UserDTO.class);
        } catch (ExceptionHortalsoft exceptionHortalsoft) {
            throw exceptionHortalsoft;
        } catch (Exception exception) {
            throw new ExceptionHortalsoft("Ha ocurrido un error inesperado", 500, layer, exception);
        }
    }
}
