package com.hortalsoft.users.domain.port.usecase.user;


import com.hortalsoft.crosscutting.util.ExceptionHortalsoft;
import com.hortalsoft.crosscutting.util.Layer;
import com.hortalsoft.users.domain.domain.User;
import com.hortalsoft.users.domain.entity.UserEntity;
import com.hortalsoft.users.domain.mapper.MapperDomainToEntity;
import com.hortalsoft.users.domain.mapper.MapperEntityToDomain;
import com.hortalsoft.users.domain.port.input.user.FindUserUseCase;
import com.hortalsoft.users.domain.repository.UserRepository;
import com.hortalsoft.users.domain.specification.UserExistByIdSpec;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class FindUserService implements FindUserUseCase {

    private static final Layer layer = Layer.DOMAIN;
    private final UserRepository userRepository;
    MapperDomainToEntity<User, UserEntity> mapperDomainToEntity = new MapperDomainToEntity<>();
    MapperEntityToDomain<UserEntity, User> mapperEntityToDomain = new MapperEntityToDomain<>();

    @Autowired
    public FindUserService(UserRepository userRepository) {
        this.userRepository = userRepository;

    }


    @Override
    public User execute(User domain) {
        try {
            UserExistByIdSpec userExistByIdSpec = new UserExistByIdSpec(userRepository);
            UserEntity entity = mapperDomainToEntity.mapToEntity(domain, UserEntity.class);
            if (userExistByIdSpec.isSatisfiedBy(entity)) {
                Optional<UserEntity> resultEntity = userRepository.findById(entity.getId());
                return mapperEntityToDomain.mapToDomain(resultEntity.get(), User.class);
            } else {
                throw new ExceptionHortalsoft("Usuario no encontrada", 6001, layer);
            }
        } catch (ExceptionHortalsoft exceptionHortalsoft) {
            throw exceptionHortalsoft;
        } catch (Exception exception) {
            throw new ExceptionHortalsoft("Ha ocurrido un error inesperado buscando el usuario" , 500, layer, exception);
        }
    }
}
