package com.hortalsoft.users.domain.port.usecase.farmer;

import com.hortalsoft.crosscutting.util.ExceptionHortalsoft;
import com.hortalsoft.crosscutting.util.Layer;
import com.hortalsoft.users.domain.domain.Farmer;
import com.hortalsoft.users.domain.entity.FarmerEntity;
import com.hortalsoft.users.domain.mapper.MapperDomainToEntity;
import com.hortalsoft.users.domain.port.input.farmer.CreateFarmerUseCase;
import com.hortalsoft.users.domain.repository.FarmerRepository;
import com.hortalsoft.users.domain.repository.UserRepository;
import com.hortalsoft.users.domain.specification.user.UserExistByIdSpec;
import org.springframework.stereotype.Service;


@Service
public class CreateFarmerService implements CreateFarmerUseCase {
    private static final Layer layer = Layer.DOMAIN;
    private final UserRepository userRepository;
    private final FarmerRepository farmerRepository;
    MapperDomainToEntity<Farmer, FarmerEntity> mapperDomainToEntity = new MapperDomainToEntity<>();

    public CreateFarmerService(UserRepository userRepository, FarmerRepository farmerRepository) {
        this.userRepository = userRepository;
        this.farmerRepository = farmerRepository;
    }

    @Override
    public void execute(Farmer domain) {
        try {
            UserExistByIdSpec userExistByIdSpec = new UserExistByIdSpec(userRepository);
            if (!userExistByIdSpec.isSatisfiedBy(domain.getId())) {
                FarmerEntity entity = mapperDomainToEntity.mapToEntity(domain, FarmerEntity.class);
                farmerRepository.save(entity);
            } else{
                throw new ExceptionHortalsoft("El usuario ya existe", 6001, layer);
            }

        } catch (ExceptionHortalsoft exceptionHortalsoft) {
            throw exceptionHortalsoft;
        } catch (Exception exception) {
            throw new ExceptionHortalsoft("Ha ocurrido un error inesperado creando el cliente", 500, layer, exception);
        }
    }
}
