package com.hortalsoft.users.domain.port.usecase.association;


import com.hortalsoft.crosscutting.util.ExceptionHortalsoft;
import com.hortalsoft.crosscutting.util.Layer;
import com.hortalsoft.users.domain.domain.Association;
import com.hortalsoft.users.domain.domain.User;
import com.hortalsoft.users.domain.mapper.MapperUserToAssociation;
import com.hortalsoft.users.domain.port.input.association.FindAssociationUseCase;
import com.hortalsoft.users.domain.port.usecase.user.FindUserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class FindAssociationService implements FindAssociationUseCase {

    private static final Layer layer = Layer.DOMAIN;
    private final FindUserService findUserService;
    MapperUserToAssociation<User, Association> mapperUserToAssociation = new MapperUserToAssociation<>();

    @Autowired
    public FindAssociationService(FindUserService findUserService) {
        this.findUserService = findUserService;
    }


    @Override
    public Association execute(Association domain) {
        try {
            return mapperUserToAssociation.mapToAssociation(findUserService.execute(domain), Association.class);
        } catch (ExceptionHortalsoft exceptionHortalsoft) {
            throw exceptionHortalsoft;
        } catch (Exception exception) {
            throw new ExceptionHortalsoft("Ha ocurrido un error inesperado buscando la asocaición" , 500, layer, exception);
        }
    }
}
