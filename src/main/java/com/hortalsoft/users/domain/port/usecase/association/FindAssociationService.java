package com.hortalsoft.users.domain.port.usecase.association;


import com.hortalsoft.crosscutting.util.ExceptionHortalsoft;
import com.hortalsoft.crosscutting.util.Layer;
import com.hortalsoft.users.domain.domain.Association;
import com.hortalsoft.users.domain.entity.AssociationEntity;
import com.hortalsoft.users.domain.mapper.MapperEntityToDomain;
import com.hortalsoft.users.domain.port.input.association.FindAssociationUseCase;
import com.hortalsoft.users.domain.repository.AssociationRepository;
import com.hortalsoft.users.domain.repository.UserRepository;
import com.hortalsoft.users.domain.specification.user.UserExistByIdSpec;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@Transactional
public class FindAssociationService implements FindAssociationUseCase {

    private static final Layer layer = Layer.DOMAIN;
    private final UserRepository userRepository;
    private final AssociationRepository associationRepository;
    MapperEntityToDomain<AssociationEntity, Association> mapperEntityToDomain = new MapperEntityToDomain<>();


    @Autowired
    public FindAssociationService( UserRepository userRepository, AssociationRepository associationRepository) {
        this.userRepository = userRepository;
        this.associationRepository = associationRepository;
    }


    @Override
    public Association execute(Association domain) {
        try {
            UserExistByIdSpec userExistByIdSpec = new UserExistByIdSpec(userRepository);
            if (userExistByIdSpec.isSatisfiedBy(domain.getIdUser())){
                Optional<AssociationEntity> resultEntity = associationRepository.findById(domain.getIdUser());
                return mapperEntityToDomain.mapToDomain(resultEntity.get(), Association.class);            }
            else{
                throw new ExceptionHortalsoft("Usuario no encontrada", 6001, layer);
            }
        } catch (ExceptionHortalsoft exceptionHortalsoft) {
            throw exceptionHortalsoft;
        } catch (Exception exception) {
            throw new ExceptionHortalsoft("Ha ocurrido un error inesperado buscando la asocaición" , 500, layer, exception);
        }
    }
}
