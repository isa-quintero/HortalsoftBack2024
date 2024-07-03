package com.hortalsoft.users.domain.port.usecase.customer;


import com.hortalsoft.crosscutting.util.ExceptionHortalsoft;
import com.hortalsoft.crosscutting.util.Layer;
import com.hortalsoft.users.domain.domain.Customer;
import com.hortalsoft.users.domain.entity.CustomerEntity;
import com.hortalsoft.users.domain.mapper.MapperDomainToEntity;
import com.hortalsoft.users.domain.mapper.MapperEntityToDomain;
import com.hortalsoft.users.domain.port.input.customer.FindCustomerUseCase;
import com.hortalsoft.users.domain.repository.CustomerRepository;
import com.hortalsoft.users.domain.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class FindCustomerService implements FindCustomerUseCase {

    private static final Layer layer = Layer.DOMAIN;
    private final UserRepository userRepository;
    private final CustomerRepository customerRepository;
    MapperDomainToEntity<Customer, CustomerEntity> mapperDomainToEntity = new MapperDomainToEntity<>();
    MapperEntityToDomain<CustomerEntity, Customer> mapperEntityToDomain = new MapperEntityToDomain<>();

    @Autowired
    public FindCustomerService(UserRepository userRepository, CustomerRepository customerRepository) {
        this.userRepository = userRepository;
        this.customerRepository = customerRepository;
    }


    @Override
    public Customer execute(Customer domain) {
        try {
            CustomerEntity entity = mapperDomainToEntity.mapToEntity(domain, CustomerEntity.class);
            Optional<CustomerEntity> resultEntity = customerRepository.findById(entity.getId());
            return mapperEntityToDomain.mapToDomain(resultEntity.get(), Customer.class);
        } catch (ExceptionHortalsoft exceptionHortalsoft) {
            throw exceptionHortalsoft;
        } catch (Exception exception) {
            throw new ExceptionHortalsoft("Ha ocurrido un error inesperado buscando el cliente" , 500, layer, exception);
        }
    }
}
