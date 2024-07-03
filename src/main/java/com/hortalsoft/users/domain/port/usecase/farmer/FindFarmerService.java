package com.hortalsoft.users.domain.port.usecase.farmer;


import com.hortalsoft.crosscutting.util.ExceptionHortalsoft;
import com.hortalsoft.crosscutting.util.Layer;
import com.hortalsoft.users.domain.domain.Farmer;
import com.hortalsoft.users.domain.entity.FarmerEntity;
import com.hortalsoft.users.domain.mapper.MapperDomainToEntity;
import com.hortalsoft.users.domain.mapper.MapperEntityToDomain;
import com.hortalsoft.users.domain.port.input.farmer.FindFarmerUseCase;
import com.hortalsoft.users.domain.repository.FarmerRepository;
import com.hortalsoft.users.domain.repository.UserRepository;
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
    MapperEntityToDomain<FarmerEntity, Farmer> mapperEntityToDomain = new MapperEntityToDomain<>();

    @Autowired
    public FindFarmerService(UserRepository userRepository, FarmerRepository farmerRepository) {
        this.userRepository = userRepository;
        this.farmerRepository = farmerRepository;
    }


    @Override
    public Farmer execute(Farmer domain) {
        try {
            FarmerEntity entity = mapperDomainToEntity.mapToEntity(domain, FarmerEntity.class);
            Optional<FarmerEntity> resultEntity = farmerRepository.findById(entity.getId());
            return mapperEntityToDomain.mapToDomain(resultEntity.get(), Farmer.class);

        } catch (ExceptionHortalsoft exceptionHortalsoft) {
            throw exceptionHortalsoft;
        } catch (Exception exception) {
            throw new ExceptionHortalsoft("Ha ocurrido un error inesperado buscando el agricultor" , 500, layer, exception);
        }
    }
}
