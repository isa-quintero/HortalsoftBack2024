package com.hortalsoft.users.domain.port.usecase.farmer;

import com.hortalsoft.crosscutting.util.ExceptionHortalsoft;
import com.hortalsoft.crosscutting.util.Layer;
import com.hortalsoft.users.domain.domain.Farmer;
import com.hortalsoft.users.domain.entity.AssociationEntity;
import com.hortalsoft.users.domain.entity.FarmerEntity;
import com.hortalsoft.users.domain.mapper.MapperDomainToEntity;
import com.hortalsoft.users.domain.port.input.farmer.CreateFarmerUseCase;
import com.hortalsoft.users.domain.repository.AssociationRepository;
import com.hortalsoft.users.domain.repository.FarmerRepository;
import com.hortalsoft.users.domain.repository.UserRepository;
import com.hortalsoft.users.domain.specification.farmer.EmptyAttributesFarmerSpec;
import com.hortalsoft.users.domain.specification.user.UniqueIdNumberSpec;
import org.springframework.stereotype.Service;


@Service
public class CreateFarmerService implements CreateFarmerUseCase {
    private static final Layer layer = Layer.DOMAIN;
    private final UserRepository userRepository;
    private final FarmerRepository farmerRepository;
    private final AssociationRepository associationRepository;
    MapperDomainToEntity<Farmer, FarmerEntity> mapperDomainToEntity = new MapperDomainToEntity<>();

    public CreateFarmerService(UserRepository userRepository, FarmerRepository farmerRepository, AssociationRepository associationRepository) {
        this.userRepository = userRepository;
        this.farmerRepository = farmerRepository;
        this.associationRepository = associationRepository;
    }

    @Override
    public void execute(Farmer domain) {
        try {
            EmptyAttributesFarmerSpec emptyAttributesFarmerSpec = new EmptyAttributesFarmerSpec();
            UniqueIdNumberSpec uniqueIdNumberSpec = new UniqueIdNumberSpec(userRepository);
            FarmerEntity entity = mapperDomainToEntity.mapToEntity(domain, FarmerEntity.class);
            if (!emptyAttributesFarmerSpec.isSatisfiedBy(entity)) {
                if (!uniqueIdNumberSpec.isSatisfiedBy(domain.getNumberId())) {
                    if (domain.getAssociationId() != null) {
                        AssociationEntity association = associationRepository.findById(domain.getAssociationId())
                                .orElseThrow(() -> new ExceptionHortalsoft("Asociación no encontrada",6001,layer));
                        entity.setAssociation(association);
                    }
                    farmerRepository.save(entity);
                } else{
                    throw new ExceptionHortalsoft("El usuario ya existe", 6001, layer);
                }
            } else{
                throw new ExceptionHortalsoft("Existen elementos vacios dentro del perfil de agricultor", 5001, layer);
            }

        } catch (ExceptionHortalsoft exceptionHortalsoft) {
            throw exceptionHortalsoft;
        } catch (Exception exception) {
            throw new ExceptionHortalsoft("Ha ocurrido un error inesperado creando el cliente", 500, layer, exception);
        }
    }
}
