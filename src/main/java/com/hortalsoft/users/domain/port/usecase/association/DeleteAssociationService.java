package com.hortalsoft.users.domain.port.usecase.association;


import com.hortalsoft.crosscutting.util.ExceptionHortalsoft;
import com.hortalsoft.crosscutting.util.Layer;
import com.hortalsoft.products.domain.entity.ProductEntity;
import com.hortalsoft.users.domain.domain.Association;
import com.hortalsoft.users.domain.entity.AssociationEntity;
import com.hortalsoft.users.domain.mapper.MapperDomainToEntity;
import com.hortalsoft.users.domain.port.input.association.DeleteAssociationUseCase;
import com.hortalsoft.users.domain.repository.AssociationRepository;
import com.hortalsoft.users.domain.repository.UserRepository;
import com.hortalsoft.users.domain.specification.user.UserExistByIdSpec;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class DeleteAssociationService implements DeleteAssociationUseCase {

    private final AssociationRepository associationRepository;
    private final UserRepository userRepository;
    private static final Layer layer = Layer.DOMAIN;
    MapperDomainToEntity<Association, AssociationEntity> mapperDomainToEntity = new MapperDomainToEntity<>();

    @Autowired
    public DeleteAssociationService(AssociationRepository associationRepository, UserRepository userRepository) {
        this.associationRepository = associationRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void execute(Association domain) {
        try {
            AssociationEntity entity = mapperDomainToEntity.mapToEntity(domain, AssociationEntity.class);
            UserExistByIdSpec userExistByIdSpec = new UserExistByIdSpec(userRepository);
            if (userExistByIdSpec.isSatisfiedBy(entity.getIdUser())){
                associationRepository.deleteById(entity.getIdUser());
            } else{
                throw new ExceptionHortalsoft("Usuario no encontrada", 6001, layer);
            }

        } catch (ExceptionHortalsoft exceptionHortalsoft) {
            throw exceptionHortalsoft;
        } catch (Exception exception) {
            throw new ExceptionHortalsoft("Ha ocurrido un error inesperado eliminando la asociación", 500, layer, exception);
        }
    }
}
