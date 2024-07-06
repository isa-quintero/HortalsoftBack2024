package com.hortalsoft.users.domain.port.usecase.customer;


import com.hortalsoft.crosscutting.util.ExceptionHortalsoft;
import com.hortalsoft.crosscutting.util.Layer;
import com.hortalsoft.users.domain.domain.Customer;
import com.hortalsoft.users.domain.entity.CustomerEntity;
import com.hortalsoft.users.domain.mapper.MapperEntityToDomain;
import com.hortalsoft.users.domain.port.input.customer.FindCustomerEmailUseCase;
import com.hortalsoft.users.domain.repository.CustomerRepository;
import com.hortalsoft.users.domain.repository.UserRepository;
import com.hortalsoft.users.domain.specification.user.UserExistByEmailSpec;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@Transactional
public class FindCustomerEmailService implements FindCustomerEmailUseCase {

    private static final Layer layer = Layer.DOMAIN;
    private final UserRepository userRepository;
    private final CustomerRepository customerRepository;
    MapperEntityToDomain<CustomerEntity, Customer> mapperEntityToDomain = new MapperEntityToDomain<>();

    @Autowired
    public FindCustomerEmailService(UserRepository userRepository, CustomerRepository customerRepository) {
        this.userRepository = userRepository;
        this.customerRepository = customerRepository;
    }


    @Override
    public Customer execute(Customer domain) {
        try {
            UserExistByEmailSpec userExistByEmailSpec = new UserExistByEmailSpec(userRepository);
            if (userExistByEmailSpec.isSatisfiedBy(domain.getEmail())) {
                Optional<CustomerEntity> resultEntity = customerRepository.findByEmail(domain.getEmail());
                return mapperEntityToDomain.mapToDomain(resultEntity.get(), Customer.class);
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
