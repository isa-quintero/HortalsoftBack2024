package com.hortalsoft.users.domain.port.usecase.user;


import com.hortalsoft.crosscutting.util.ExceptionHortalsoft;
import com.hortalsoft.crosscutting.util.Layer;
import com.hortalsoft.users.domain.domain.User;
import com.hortalsoft.users.domain.entity.UserEntity;
import com.hortalsoft.users.domain.mapper.MapperDomainToEntity;
import com.hortalsoft.users.domain.mapper.MapperEntityToDomain;
import com.hortalsoft.users.domain.port.input.user.FindUserEmailUseCase;
import com.hortalsoft.users.domain.repository.UserRepository;
import com.hortalsoft.users.domain.specification.user.UserExistByEmailSpec;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class FindUserEmailService implements FindUserEmailUseCase {

    private static final Layer layer = Layer.DOMAIN;
    private final UserRepository userRepository;
    MapperDomainToEntity<User, UserEntity> mapperDomainToEntity = new MapperDomainToEntity<>();
    MapperEntityToDomain<UserEntity, User> mapperEntityToDomain = new MapperEntityToDomain<>();

    @Autowired
    public FindUserEmailService(UserRepository userRepository) {
        this.userRepository = userRepository;

    }


    @Override
    public User execute(User domain) {
        try {
            UserExistByEmailSpec userExistByEmailSpec = new UserExistByEmailSpec(userRepository);
            UserEntity entity = mapperDomainToEntity.mapToEntity(domain, UserEntity.class);
            if (userExistByEmailSpec.isSatisfiedBy(entity)) {
                Optional<UserEntity> resultEntity = userRepository.findByEmail(entity.getEmail());
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
