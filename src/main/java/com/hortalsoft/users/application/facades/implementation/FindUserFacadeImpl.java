package com.hortalsoft.users.application.facades.implementation;

import com.hortalsoft.crosscutting.util.ExceptionHortalsoft;
import com.hortalsoft.crosscutting.util.Layer;
import com.hortalsoft.users.application.dto.UserDTO;
import com.hortalsoft.users.application.facades.facade.user.FindUserFacade;
import com.hortalsoft.users.application.mapper.MapperDTOToDomain;
import com.hortalsoft.users.application.mapper.MapperDomainToDto;
import com.hortalsoft.users.domain.domain.User;
import com.hortalsoft.users.domain.port.input.user.FindUserUseCase;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class FindUserFacadeImpl implements FindUserFacade {
    MapperDTOToDomain<UserDTO, User> mapperDTOToDomain = new MapperDTOToDomain<>();
    MapperDomainToDto<User, UserDTO> mapperDomainToDto = new MapperDomainToDto<>();
    private final FindUserUseCase useCase;
    private static final Layer layer = Layer.APPLICATION;

    public FindUserFacadeImpl(FindUserUseCase useCase) {
        this.useCase = useCase;
    }

    @Override
    public UserDTO execute(UserDTO dto) {
        try {
            User domain = mapperDTOToDomain.mapToDomain(dto, User.class);
            return mapperDomainToDto.mapToDto(useCase.execute(domain), UserDTO.class);
        } catch (ExceptionHortalsoft exceptionHortalsoft) {
            throw exceptionHortalsoft;
        } catch (Exception exception) {
            throw new ExceptionHortalsoft("ha ocurrido un error inesperado", 500, layer, exception);
        }
    }
}
