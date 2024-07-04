package com.hortalsoft.users.domain.port.usecase.farmer;

import com.hortalsoft.crosscutting.util.ExceptionHortalsoft;
import com.hortalsoft.crosscutting.util.Layer;
import com.hortalsoft.users.domain.domain.Farmer;
import com.hortalsoft.users.domain.entity.FarmerEntity;
import com.hortalsoft.users.domain.mapper.MapperDomainToEntity;
import com.hortalsoft.users.domain.port.input.farmer.CreateFarmerUseCase;
import com.hortalsoft.users.domain.repository.FarmerRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateFarmerService implements CreateFarmerUseCase {
    private static final Layer layer = Layer.DOMAIN;
    private final FarmerRepository farmerRepository;
    MapperDomainToEntity<Farmer, FarmerEntity> mapperDomainToEntity = new MapperDomainToEntity<>();

    public CreateFarmerService(FarmerRepository farmerRepository) {
        this.farmerRepository = farmerRepository;
    }

    @Override
    public void execute(Farmer domain) {
        try {
            FarmerEntity entity = mapperDomainToEntity.mapToEntity(domain, FarmerEntity.class);
            farmerRepository.save(entity);
        } catch (ExceptionHortalsoft exceptionHortalsoft) {
            throw exceptionHortalsoft;
        } catch (Exception exception) {
            throw new ExceptionHortalsoft("Ha ocurrido un error inesperado creando el cliente", 500, layer, exception);
        }
    }
}
