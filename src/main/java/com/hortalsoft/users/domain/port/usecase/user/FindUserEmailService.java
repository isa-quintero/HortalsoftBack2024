package com.hortalsoft.users.domain.port.usecase.user;


import com.hortalsoft.crosscutting.util.ExceptionHortalsoft;
import com.hortalsoft.crosscutting.util.Layer;
import com.hortalsoft.users.domain.domain.Association;
import com.hortalsoft.users.domain.domain.Customer;
import com.hortalsoft.users.domain.domain.Farmer;
import com.hortalsoft.users.domain.domain.User;
import com.hortalsoft.users.domain.entity.CustomerEntity;
import com.hortalsoft.users.domain.entity.UserEntity;
import com.hortalsoft.users.domain.mapper.MapperDomainToEntity;
import com.hortalsoft.users.domain.mapper.MapperEntityToDomain;
import com.hortalsoft.users.domain.mapper.MapperEntityToDomainFarmer;
import com.hortalsoft.users.domain.port.input.user.FindUserEmailUseCase;
import com.hortalsoft.users.domain.port.usecase.association.FindAssociationEmailService;
import com.hortalsoft.users.domain.port.usecase.customer.FindCustomerEmailService;
import com.hortalsoft.users.domain.port.usecase.farmer.FindFarmerEmailService;
import com.hortalsoft.users.domain.repository.UserRepository;
import com.hortalsoft.users.domain.specification.user.UserExistByEmailSpec;
import com.hortalsoft.users.util.UserType;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.hortalsoft.users.util.UserType.FARMER;

@Service
@Transactional
public class FindUserEmailService implements FindUserEmailUseCase {

    private static final Layer layer = Layer.DOMAIN;
    private final UserRepository userRepository;
    private final FindUserService findUserService;
    private final FindFarmerEmailService findFarmerEmailService;
    private final FindCustomerEmailService findCustomerEmailService;
    private final FindAssociationEmailService findAssociationEmailService;
    MapperDomainToEntity<User, CustomerEntity> mapperDomainToEntity = new MapperDomainToEntity<>();
    MapperEntityToDomain<UserEntity, Customer> mapperEntityToDomainCustomer = new MapperEntityToDomain<>();
    private final MapperEntityToDomainFarmer mapperEntityToDomainFarmer;
    MapperEntityToDomain<UserEntity, Association> mapperEntityToDomainAssociation = new MapperEntityToDomain<>();

    @Autowired
    public FindUserEmailService(UserRepository userRepository, MapperEntityToDomainFarmer mapperEntityToDomainFarmer, FindUserService findUserService, FindFarmerEmailService findFarmerEmailService, FindCustomerEmailService findCustomerEmailService, FindAssociationEmailService findAssociationEmailService) {
        this.userRepository = userRepository;

        this.mapperEntityToDomainFarmer = mapperEntityToDomainFarmer;
        this.findUserService = findUserService;
        this.findFarmerEmailService = findFarmerEmailService;
        this.findCustomerEmailService = findCustomerEmailService;
        this.findAssociationEmailService = findAssociationEmailService;
    }


    @Override
    public User execute(User domain) {
        try {
            UserExistByEmailSpec userExistByEmailSpec = new UserExistByEmailSpec(userRepository);
            UserEntity entity = mapperDomainToEntity.mapToEntity(domain, CustomerEntity.class);
            if (userExistByEmailSpec.isSatisfiedBy(entity.getEmail())) {
                Optional<UserEntity> resultEntity = userRepository.findByEmail(entity.getEmail());
                if(resultEntity.get().getUserType() == FARMER) {
                    Farmer result = new Farmer(0, 0, 0, "", 0, entity.getEmail(), "", "", 0);
                    return findFarmerEmailService.execute((Farmer) result);
                } else if(resultEntity.get().getUserType() == UserType.CUSTOMER) {
                    return findCustomerEmailService.execute((Customer) domain);
                } else if (resultEntity.get().getUserType() == UserType.ASSOCIATION) {
                    Association result = new Association(0, 0, 0, "", 0, entity.getEmail(), "", "", "");
                    return findAssociationEmailService.execute((Association) result);
                } else {
                    throw new ExceptionHortalsoft("Error encontrando el usuario", 6001, layer);
                }
            } else {
                throw new ExceptionHortalsoft("Usuario no encontrada", 6001, layer);
            }
        } catch (ExceptionHortalsoft exceptionHortalsoft) {
            throw exceptionHortalsoft;
        } catch (Exception exception) {
            throw new ExceptionHortalsoft("Ha ocurrido un error inesperado buscando el usuario" , 500, layer, exception);
        }
    }
}
