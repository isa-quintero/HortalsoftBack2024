package com.hortalsoft.users.domain.port.usecase.association;


import com.hortalsoft.crosscutting.util.ExceptionHortalsoft;
import com.hortalsoft.crosscutting.util.Layer;
import com.hortalsoft.users.domain.domain.Association;
import com.hortalsoft.users.domain.entity.AssociationEntity;
import com.hortalsoft.users.domain.mapper.MapperEntityToDomain;
import com.hortalsoft.users.domain.port.input.association.ListAssociationUseCase;
import com.hortalsoft.users.domain.repository.AssociationRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ListAssociationService implements ListAssociationUseCase {

    private static final Layer layer = Layer.DOMAIN;
    private final AssociationRepository associationRepository;
    MapperEntityToDomain<AssociationEntity, Association> mapperEntityToDomain = new MapperEntityToDomain<>();


    @Autowired
    public ListAssociationService(AssociationRepository associationRepository) {
        this.associationRepository = associationRepository;
    }


    @Override
    public List<Association> execute() {
        try {
            if (associationRepository.count() != 0) {
                List<AssociationEntity> resultList = associationRepository.findAll();
                return mapperEntityToDomain.mapToDomainList(resultList, Association.class);
            } else {
                throw new ExceptionHortalsoft("No hay asociaciones para mostrar", 6001, layer);
            }
        } catch (ExceptionHortalsoft exceptionHortalsoft) {
            throw exceptionHortalsoft;
        } catch (Exception exception) {
            throw new ExceptionHortalsoft("Ha ocurrido un error inesperado listando las asociaciones", 500, layer, exception);
        }
    }
}
