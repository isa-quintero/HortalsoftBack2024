package com.hortalsoft.users.domain.port.usecase.association;

import com.hortalsoft.crosscutting.util.ExceptionHortalsoft;
import com.hortalsoft.crosscutting.util.Layer;
import com.hortalsoft.users.domain.domain.Association;
import com.hortalsoft.users.domain.entity.AssociationEntity;
import com.hortalsoft.users.domain.mapper.MapperDomainToEntity;
import com.hortalsoft.users.domain.port.input.association.CreateAssociationUseCase;
import com.hortalsoft.users.domain.repository.AssociationRepository;
import org.springframework.stereotype.Service;


@Service
public class CreateAssociationService implements CreateAssociationUseCase {

    private static final Layer layer = Layer.DOMAIN;
    private final AssociationRepository associationRepository;
    MapperDomainToEntity<Association, AssociationEntity> mapperDomainToEntity = new MapperDomainToEntity<>();

    public CreateAssociationService(AssociationRepository associationRepository) {
        this.associationRepository = associationRepository;
    }

    @Override
    public void execute(Association domain) {
        try {
            //ValidateUserCreatedSpec validateUserCreatedSpec = new ValidateUserCreatedSpec(associationRepository);
            AssociationEntity entity = mapperDomainToEntity.mapToEntity(domain, AssociationEntity.class);
            //if (validateUserCreatedSpec.isSatisfiedBy(entity)) {
                associationRepository.save(entity);
            //} else {
                //throw new ExceptionHortalsoft("La asociación ya existe", 5001, layer);
           // }
        } catch (ExceptionHortalsoft exceptionHortalsoft) {
            throw exceptionHortalsoft;
        } catch (Exception exception) {
            throw new ExceptionHortalsoft("Ha ocurrido un error inesperado creando la asociación", 500, layer, exception);
        }
    }
}
