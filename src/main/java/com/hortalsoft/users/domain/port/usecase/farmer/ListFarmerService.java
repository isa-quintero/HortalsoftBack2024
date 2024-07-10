package com.hortalsoft.users.domain.port.usecase.farmer;

import com.hortalsoft.crosscutting.util.ExceptionHortalsoft;
import com.hortalsoft.crosscutting.util.Layer;
import com.hortalsoft.users.domain.domain.Farmer;
import com.hortalsoft.users.domain.entity.FarmerEntity;
import com.hortalsoft.users.domain.mapper.MapperEntityToDomainFarmer;
import com.hortalsoft.users.domain.port.input.farmer.ListFarmerUseCase;
import com.hortalsoft.users.domain.repository.FarmerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ListFarmerService implements ListFarmerUseCase {

    private static final Layer layer = Layer.DOMAIN;
    private final FarmerRepository farmerRepository;
    private final MapperEntityToDomainFarmer mapperFarmerToDomain;

    @Autowired
    public ListFarmerService(FarmerRepository farmerRepository, MapperEntityToDomainFarmer mapperFarmerToDomain) {
        this.farmerRepository = farmerRepository;
        this.mapperFarmerToDomain = mapperFarmerToDomain;
    }

    @Override
    public List<Farmer> execute() {
        try {
            if (farmerRepository.count() != 0) {
                List<FarmerEntity> resultList = farmerRepository.findAll();
                return mapperFarmerToDomain.mapToDomainList(resultList);
            } else {
                throw new ExceptionHortalsoft("No hay agricultores para mostrar", 6001, layer);
            }
        } catch (ExceptionHortalsoft exceptionHortalsoft) {
            throw exceptionHortalsoft;
        } catch (Exception exception) {
            throw new ExceptionHortalsoft("Ha ocurrido un error inesperado listando los agricultores", 500, layer, exception);
        }
    }
}
