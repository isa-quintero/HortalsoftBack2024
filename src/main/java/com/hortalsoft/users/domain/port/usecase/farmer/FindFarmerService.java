package com.hortalsoft.users.domain.port.usecase.farmer;


import com.hortalsoft.crosscutting.util.ExceptionHortalsoft;
import com.hortalsoft.crosscutting.util.Layer;
import com.hortalsoft.users.domain.domain.Farmer;
import com.hortalsoft.users.domain.entity.FarmerEntity;
import com.hortalsoft.users.domain.mapper.MapperDomainToEntity;
import com.hortalsoft.users.domain.mapper.MapperEntityToDomainFarmer;
import com.hortalsoft.users.domain.port.input.farmer.FindFarmerUseCase;
import com.hortalsoft.users.domain.repository.FarmerRepository;
import com.hortalsoft.users.domain.repository.UserRepository;
import com.hortalsoft.users.domain.specification.user.UserExistByIdSpec;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class FindFarmerService implements FindFarmerUseCase {

    private static final Layer layer = Layer.DOMAIN;
    private final UserRepository userRepository;
    private final FarmerRepository farmerRepository;
    MapperDomainToEntity<Farmer, FarmerEntity> mapperDomainToEntity = new MapperDomainToEntity<>();
    private final MapperEntityToDomainFarmer mapperEntityToDomain;

    @Autowired
    public FindFarmerService(UserRepository userRepository, FarmerRepository farmerRepository, MapperEntityToDomainFarmer mapperEntityToDomain) {
        this.userRepository = userRepository;
        this.farmerRepository = farmerRepository;
        this.mapperEntityToDomain = mapperEntityToDomain;
    }


    @Override
    public Farmer execute(Farmer domain) {
        try {
            UserExistByIdSpec userExistByIdSpec = new UserExistByIdSpec(userRepository);
            if (userExistByIdSpec.isSatisfiedBy(domain.getIdUser())) {
                FarmerEntity entity = mapperDomainToEntity.mapToEntity(domain, FarmerEntity.class);
                Optional<FarmerEntity> resultEntity = farmerRepository.findById(entity.getIdUser());
                return mapperEntityToDomain.mapToFarmer(resultEntity.get());
            } else{
                throw new ExceptionHortalsoft("Usuario no encontrada", 6001, layer);
            }

        } catch (ExceptionHortalsoft exceptionHortalsoft) {
            throw exceptionHortalsoft;
        } catch (Exception exception) {
            throw new ExceptionHortalsoft("Ha ocurrido un error inesperado buscando el agricultor" , 500, layer, exception);
        }
    }
}
