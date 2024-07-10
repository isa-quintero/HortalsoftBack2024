package com.hortalsoft.users.domain.port.usecase.association;

import com.hortalsoft.crosscutting.util.ExceptionHortalsoft;
import com.hortalsoft.crosscutting.util.Layer;
import com.hortalsoft.users.domain.domain.Association;
import com.hortalsoft.users.domain.entity.AssociationEntity;
import com.hortalsoft.users.domain.mapper.MapperDomainToEntity;
import com.hortalsoft.users.domain.port.input.association.CreateAssociationUseCase;
import com.hortalsoft.users.domain.repository.AssociationRepository;
import com.hortalsoft.users.domain.repository.UserRepository;
import com.hortalsoft.users.domain.specification.user.UniqueIdNumberSpec;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CreateAssociationService implements CreateAssociationUseCase {

    private static final Layer layer = Layer.DOMAIN;
    private final AssociationRepository associationRepository;
    private final UserRepository userRepository;
    MapperDomainToEntity<Association, AssociationEntity> mapperDomainToEntity = new MapperDomainToEntity<>();


    public CreateAssociationService(AssociationRepository associationRepository, UserRepository userRepository) {
        this.associationRepository = associationRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void execute(Association domain) {
        try {
            UniqueIdNumberSpec uniqueIdNumberSpec = new UniqueIdNumberSpec(userRepository);
            if (!uniqueIdNumberSpec.isSatisfiedBy(domain.getNumberId())) {
                AssociationEntity entity = mapperDomainToEntity.mapToEntity(domain, AssociationEntity.class);
                associationRepository.save(entity);
            } else{
                throw new ExceptionHortalsoft("El usuario ya existe", 6001, layer);
            }

        } catch (ExceptionHortalsoft exceptionHortalsoft) {
            throw exceptionHortalsoft;
        } catch (Exception exception) {
            throw new ExceptionHortalsoft("Ha ocurrido un error inesperado creando la asociación", 500, layer, exception);
        }
    }
}
