package com.hortalsoft.users.domain.port.usecase.association;

import com.hortalsoft.crosscutting.util.ExceptionHortalsoft;
import com.hortalsoft.crosscutting.util.Layer;
import com.hortalsoft.users.domain.domain.Association;
import com.hortalsoft.users.domain.entity.AssociationEntity;
import com.hortalsoft.users.domain.mapper.MapperDomainToEntity;
import com.hortalsoft.users.domain.port.usecase.user.AbstractUserService;
import com.hortalsoft.users.domain.repository.AssociationRepository;
import com.hortalsoft.users.domain.repository.UserRepository;
import com.hortalsoft.users.domain.specification.user.ValidateUserCreatedSpec;
import org.springframework.stereotype.Service;


@Service
public class CreateAssociationService  extends AbstractUserService<Association> {

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
            AssociationEntity entity = mapperDomainToEntity.mapToEntity(domain, AssociationEntity.class);
            associationRepository.save(entity);
        } catch (ExceptionHortalsoft exceptionHortalsoft) {
            throw exceptionHortalsoft;
        } catch (Exception exception) {
            throw new ExceptionHortalsoft("Ha ocurrido un error inesperado creando la asociación", 500, layer, exception);
        }
    }
}
