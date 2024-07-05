package com.hortalsoft.users.domain.port.usecase.association;


import com.hortalsoft.crosscutting.util.ExceptionHortalsoft;
import com.hortalsoft.crosscutting.util.Layer;
import com.hortalsoft.products.domain.mapper.MapperDomainToEntity;
import com.hortalsoft.users.domain.domain.Association;
import com.hortalsoft.users.domain.entity.AssociationEntity;
import com.hortalsoft.users.domain.port.input.association.DeleteAssociationUseCase;
import com.hortalsoft.users.domain.repository.AssociationRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class DeleteAssociationService implements DeleteAssociationUseCase {

    private final AssociationRepository associationRepository;

    private static final Layer layer = Layer.DOMAIN;
    MapperDomainToEntity<Association, AssociationEntity> mapperDomainToEntity = new MapperDomainToEntity<>();

    @Autowired
    public DeleteAssociationService(AssociationRepository associationRepository) {
        this.associationRepository = associationRepository;
    }

    @Override
    public void execute(Association domain) {
        try {
            AssociationEntity entity = mapperDomainToEntity.mapToEntity(domain, AssociationEntity.class);
            associationRepository.deleteById(domain.getId());

        } catch (ExceptionHortalsoft exceptionHortalsoft) {
            throw exceptionHortalsoft;
        } catch (Exception exception) {
            throw new ExceptionHortalsoft("Ha ocurrido un error inesperado eliminando la asociación", 500, layer, exception);
        }
    }
}
