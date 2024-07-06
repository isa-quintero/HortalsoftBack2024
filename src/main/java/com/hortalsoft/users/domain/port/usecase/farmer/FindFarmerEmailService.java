package com.hortalsoft.users.domain.port.usecase.farmer;


import com.hortalsoft.crosscutting.util.ExceptionHortalsoft;
import com.hortalsoft.crosscutting.util.Layer;
import com.hortalsoft.users.domain.domain.Farmer;
import com.hortalsoft.users.domain.entity.FarmerEntity;
import com.hortalsoft.users.domain.mapper.MapperEntityToDomain;
import com.hortalsoft.users.domain.port.input.farmer.FindFarmerEmailUseCase;
import com.hortalsoft.users.domain.repository.FarmerRepository;
import com.hortalsoft.users.domain.repository.UserRepository;
import com.hortalsoft.users.domain.specification.user.UserExistByEmailSpec;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@Transactional
public class FindFarmerEmailService implements FindFarmerEmailUseCase {

    private static final Layer layer = Layer.DOMAIN;
    private final UserRepository userRepository;
    private final FarmerRepository farmerRepository;
    MapperEntityToDomain<FarmerEntity, Farmer> mapperEntityToDomain = new MapperEntityToDomain<>();

    @Autowired
    public FindFarmerEmailService(UserRepository userRepository, FarmerRepository farmerRepository) {
        this.userRepository = userRepository;
        this.farmerRepository = farmerRepository;
    }


    @Override
    public Farmer execute(Farmer domain) {
        try {
            UserExistByEmailSpec userExistByEmailSpec = new UserExistByEmailSpec(userRepository);
            if (userExistByEmailSpec.isSatisfiedBy(domain.getEmail())) {
                Optional<FarmerEntity> resultEntity = farmerRepository.findByEmail(domain.getEmail());
                return mapperEntityToDomain.mapToDomain(resultEntity.get(), Farmer.class);
            } else {
                throw new ExceptionHortalsoft("Usuario no encontrada", 6001, layer);
            }            } catch (ExceptionHortalsoft exceptionHortalsoft) {
            throw exceptionHortalsoft;
        } catch (Exception exception) {
            throw new ExceptionHortalsoft("Ha ocurrido un error inesperado buscando el usuario" , 500, layer, exception);
        }
    }
}
