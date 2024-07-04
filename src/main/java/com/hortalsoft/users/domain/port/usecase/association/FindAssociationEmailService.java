package com.hortalsoft.users.domain.port.usecase.association;


import com.hortalsoft.crosscutting.util.ExceptionHortalsoft;
import com.hortalsoft.crosscutting.util.Layer;
import com.hortalsoft.users.domain.domain.Association;
import com.hortalsoft.users.domain.domain.User;
import com.hortalsoft.users.domain.entity.AssociationEntity;
import com.hortalsoft.users.domain.mapper.MapperEntityToDomain;
import com.hortalsoft.users.domain.mapper.MapperUserToAssociation;
import com.hortalsoft.users.domain.port.input.association.FindAssociationEmailUseCase;
import com.hortalsoft.users.domain.port.usecase.user.FindUserEmailService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class FindAssociationEmailService implements FindAssociationEmailUseCase {

    private static final Layer layer = Layer.DOMAIN;
    private final FindUserEmailService findUserEmailService;
    MapperUserToAssociation <User, Association> mapperUserToAssociation = new MapperUserToAssociation<>();
    MapperEntityToDomain<AssociationEntity, Association> mapperEntityToDomain = new MapperEntityToDomain<>();

    @Autowired
    public FindAssociationEmailService(FindUserEmailService findUserEmailService) {
        this.findUserEmailService = findUserEmailService;
    }


    @Override
    public Association execute(Association domain) {
        try {
            return mapperUserToAssociation.mapToAssociation(findUserEmailService.execute(domain), Association.class);
        } catch (ExceptionHortalsoft exceptionHortalsoft) {
            throw exceptionHortalsoft;
        } catch (Exception exception) {
            throw new ExceptionHortalsoft("Ha ocurrido un error inesperado buscando el usuario" , 500, layer, exception);
        }
    }
}
