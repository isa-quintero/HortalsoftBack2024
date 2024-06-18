package com.hortalsoft.users.application.facades.implementation;

import com.hortalsoft.crosscutting.util.ExceptionHandlingAspect;

import com.hortalsoft.users.application.dto.UserDTO;
import com.hortalsoft.users.application.facades.facade.user.CreateUserFacade;
import com.hortalsoft.users.application.mapper.MapperDTOToDomain;
import com.hortalsoft.users.domain.domain.User;
import com.hortalsoft.users.domain.port.input.user.CreateUserUseCase;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CreateUserFacadeImpl implements CreateUserFacade {

    MapperDTOToDomain<UserDTO, User> mapperDTOToDomain = new MapperDTOToDomain<>();
    private final CreateUserUseCase useCase;
    private final ExceptionHandlingAspect exceptionHandlingAspect;

    public CreateUserFacadeImpl(CreateUserUseCase useCase, ExceptionHandlingAspect exceptionHandlingAspect) {
        this.useCase = useCase;
        this.exceptionHandlingAspect = exceptionHandlingAspect;
    }

    @Override
    public void execute(UserDTO dto) {
        try {
            User domain = mapperDTOToDomain.mapToDomain(dto, User.class);
            useCase.execute(domain);

        } catch (Exception exception) {
            exceptionHandlingAspect.exceptionsApplication(exception);
        }
    }
}
