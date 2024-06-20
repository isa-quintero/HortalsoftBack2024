package com.hortalsoft.users.domain.port.usecase.customer;


import com.hortalsoft.crosscutting.util.ExceptionHortalsoft;
import com.hortalsoft.crosscutting.util.Layer;
import com.hortalsoft.products.domain.mapper.MapperDomainToEntity;
import com.hortalsoft.users.domain.domain.User;
import com.hortalsoft.users.domain.entity.UserEntity;
import com.hortalsoft.users.domain.port.input.user.DeleteUserUseCase;
import com.hortalsoft.users.domain.repository.UserRepository;
import com.hortalsoft.users.domain.specification.UserExistByIdSpec;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class DeleteCustomerService implements DeleteUserUseCase {

    private final UserRepository userRepository;
    private static final Layer layer = Layer.DOMAIN;
    MapperDomainToEntity<User, UserEntity> mapperDomainToEntity = new MapperDomainToEntity<>();

    @Autowired
    public DeleteCustomerService(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    @Override
    public void execute(User domain) {
        try {
            UserEntity entity = mapperDomainToEntity.mapToEntity(domain, UserEntity.class);
            UserExistByIdSpec userExistByIdSpec = new UserExistByIdSpec(userRepository);
            if (userExistByIdSpec.isSatisfiedBy(entity)) {
                userRepository.deleteById(domain.getId());
            } else {
                throw new ExceptionHortalsoft("Usuario no encontrado", 6001, layer);
            }
        } catch (ExceptionHortalsoft exceptionHortalsoft) {
            throw exceptionHortalsoft;
        } catch (Exception exception) {
            throw new ExceptionHortalsoft("Ha ocurrido un error inesperado eliminando el usuario", 500, layer, exception);
        }
    }
}
