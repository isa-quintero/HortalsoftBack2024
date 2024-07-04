package com.hortalsoft.users.domain.port.usecase.farmer;


import com.hortalsoft.crosscutting.util.ExceptionHortalsoft;
import com.hortalsoft.crosscutting.util.Layer;
import com.hortalsoft.users.domain.domain.Farmer;
import com.hortalsoft.users.domain.domain.User;
import com.hortalsoft.users.domain.mapper.MapperUserToFarmer;
import com.hortalsoft.users.domain.port.input.farmer.FindFarmerEmailUseCase;
import com.hortalsoft.users.domain.port.usecase.user.FindUserEmailService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class FindFarmerEmailService implements FindFarmerEmailUseCase {

    private static final Layer layer = Layer.DOMAIN;
    private final FindUserEmailService findUserEmailService;
    MapperUserToFarmer<User, Farmer> mapperUserToFarmer = new MapperUserToFarmer<>();

    @Autowired
    public FindFarmerEmailService(FindUserEmailService findUserEmailService) {
        this.findUserEmailService = findUserEmailService;
    }


    @Override
    public Farmer execute(Farmer domain) {
        try {
            return mapperUserToFarmer.mapToFarmer(findUserEmailService.execute(domain), Farmer.class);
        } catch (ExceptionHortalsoft exceptionHortalsoft) {
            throw exceptionHortalsoft;
        } catch (Exception exception) {
            throw new ExceptionHortalsoft("Ha ocurrido un error inesperado buscando el usuario" , 500, layer, exception);
        }
    }
}
