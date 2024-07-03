package com.hortalsoft.users.domain.port.usecase.farmer;


import com.hortalsoft.crosscutting.util.ExceptionHortalsoft;
import com.hortalsoft.crosscutting.util.Layer;
import com.hortalsoft.products.domain.mapper.MapperDomainToEntity;
import com.hortalsoft.users.domain.domain.Farmer;
import com.hortalsoft.users.domain.entity.FarmerEntity;
import com.hortalsoft.users.domain.port.input.farmer.DeleteFarmerUseCase;
import com.hortalsoft.users.domain.repository.FarmerRepository;
import com.hortalsoft.users.domain.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class DeleteFarmerService implements DeleteFarmerUseCase {

    private final UserRepository userRepository;
    private final FarmerRepository farmerRepository;
    private static final Layer layer = Layer.DOMAIN;
    MapperDomainToEntity<Farmer, FarmerEntity> mapperDomainToEntity = new MapperDomainToEntity<>();

    @Autowired
    public DeleteFarmerService(UserRepository userRepository, FarmerRepository farmerRepository) {
        this.userRepository = userRepository;
        this.farmerRepository = farmerRepository;
    }

    @Override
    public void execute(Farmer domain) {
        try {
            FarmerEntity entity = mapperDomainToEntity.mapToEntity(domain, FarmerEntity.class);
            farmerRepository.deleteById(domain.getId());
        } catch (ExceptionHortalsoft exceptionHortalsoft) {
            throw exceptionHortalsoft;
        } catch (Exception exception) {
            throw new ExceptionHortalsoft("Ha ocurrido un error inesperado eliminando el agricultor", 500, layer, exception);
        }
    }
}
