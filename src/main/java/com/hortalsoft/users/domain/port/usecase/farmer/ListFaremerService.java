package com.hortalsoft.users.domain.port.usecase.farmer;


import com.hortalsoft.crosscutting.util.ExceptionHortalsoft;
import com.hortalsoft.crosscutting.util.Layer;
import com.hortalsoft.users.domain.domain.User;
import com.hortalsoft.users.domain.entity.UserEntity;
import com.hortalsoft.users.domain.mapper.MapperEntityToDomain;
import com.hortalsoft.users.domain.port.input.user.ListUserUseCase;
import com.hortalsoft.users.domain.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ListFaremerService implements ListUserUseCase {

    private static final Layer layer = Layer.DOMAIN;
    private final UserRepository userRepository;
    MapperEntityToDomain<UserEntity, User> mapperEntityToDomain = new MapperEntityToDomain<>();


    @Autowired
    public ListFaremerService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public List<User> execute() {
        try {
            if (userRepository.count() != 0) {
                List<UserEntity> resultList = userRepository.findAll();
                return mapperEntityToDomain.mapToDomainList(resultList, User.class);
            } else {
                throw new ExceptionHortalsoft("No hay usuarios para mostrar", 6001, layer);
            }
        } catch (ExceptionHortalsoft exceptionHortalsoft) {
            throw exceptionHortalsoft;
        } catch (Exception exception) {
            throw new ExceptionHortalsoft("Ha ocurrido un error inesperado listando los usuarios", 500, layer, exception);
        }
    }
}
