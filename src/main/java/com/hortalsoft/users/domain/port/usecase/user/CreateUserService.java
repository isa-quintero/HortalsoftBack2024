package com.hortalsoft.users.domain.port.usecase.user;

import com.hortalsoft.crosscutting.util.ExceptionHortalsoft;
import com.hortalsoft.crosscutting.util.Layer;
import com.hortalsoft.users.domain.domain.User;
import com.hortalsoft.users.domain.entity.UserEntity;
import com.hortalsoft.users.domain.mapper.MapperDomainToEntity;
import com.hortalsoft.users.domain.port.input.user.CreateUserUseCase;
import com.hortalsoft.users.domain.repository.UserRepository;
import com.hortalsoft.users.domain.specification.user.EmptyAttributesUserSpec;
import com.hortalsoft.users.domain.specification.user.UniqueEmailForUserSpec;
import org.springframework.stereotype.Service;


@Service
public class CreateUserService implements CreateUserUseCase {
    private static final Layer layer = Layer.DOMAIN;
    private final UserRepository userRepository;
    MapperDomainToEntity<User, UserEntity> mapperDomainToEntity = new MapperDomainToEntity<>();

    public CreateUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void execute(User domain) {
        try {
            EmptyAttributesUserSpec emptyAttributesUserSpec = new EmptyAttributesUserSpec();
            UniqueEmailForUserSpec uniqueEmailForUserSpec = new UniqueEmailForUserSpec(userRepository);
            UserEntity entity = mapperDomainToEntity.mapToEntity(domain, UserEntity.class);
            if (!emptyAttributesUserSpec.isSatisfiedBy(entity)){
                if ( uniqueEmailForUserSpec.isSatisfiedBy(entity.getEmail())){
                    userRepository.save(entity);
                } else {
                    throw new ExceptionHortalsoft("El usuario ya existe", 5001, layer);
                }
            } else{
                throw new ExceptionHortalsoft("Existen elementos vacios dentro del perfil de asociación", 5001, layer);
            }
        } catch (ExceptionHortalsoft exceptionHortalsoft) {
            throw exceptionHortalsoft;
        } catch (Exception exception) {
            throw new ExceptionHortalsoft("Ha ocurrido un error inesperado creando el cliente", 500, layer, exception);
        }

    }
}