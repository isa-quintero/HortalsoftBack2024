package com.hortalsoft.users.domain.port.usecase.customer;


import com.hortalsoft.crosscutting.util.ExceptionHortalsoft;
import com.hortalsoft.crosscutting.util.Layer;
import com.hortalsoft.users.domain.domain.Customer;
import com.hortalsoft.users.domain.entity.CustomerEntity;
import com.hortalsoft.users.domain.mapper.MapperEntityToDomain;
import com.hortalsoft.users.domain.port.input.customer.ListCustomerUseCase;
import com.hortalsoft.users.domain.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Transactional
public class ListCustomerService implements ListCustomerUseCase {

    private static final Layer layer = Layer.DOMAIN;
    private final CustomerRepository customerRepository;
    MapperEntityToDomain<CustomerEntity, Customer> mapperEntityToDomain = new MapperEntityToDomain<>();


    @Autowired
    public ListCustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @Override
    public List<Customer> execute() {
        try {
            if (customerRepository.count() != 0) {
                List<CustomerEntity> resultList = customerRepository.findAll();
                return mapperEntityToDomain.mapToDomainList(resultList, Customer.class);
            } else {
                throw new ExceptionHortalsoft("No hay clientes para mostrar", 6001, layer);
            }
        } catch (ExceptionHortalsoft exceptionHortalsoft) {
            throw exceptionHortalsoft;
        } catch (Exception exception) {
            throw new ExceptionHortalsoft("Ha ocurrido un error inesperado listando los clientes", 500, layer, exception);
        }
    }
}
