package com.hortalsoft.users.domain.port.usecase.customer;

import com.hortalsoft.crosscutting.util.ExceptionHortalsoft;
import com.hortalsoft.crosscutting.util.Layer;
import com.hortalsoft.users.domain.domain.Customer;
import com.hortalsoft.users.domain.entity.CustomerEntity;
import com.hortalsoft.users.domain.mapper.MapperDomainToEntity;
import com.hortalsoft.users.domain.port.input.customer.CreateCustomerUseCase;
import com.hortalsoft.users.domain.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateCustomerService  implements CreateCustomerUseCase {
    private static final Layer layer = Layer.DOMAIN;
    private final CustomerRepository customerRepository;
    MapperDomainToEntity<Customer, CustomerEntity> mapperDomainToEntity = new MapperDomainToEntity<>();

    public CreateCustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void execute(Customer domain) {
        try {
            CustomerEntity entity = mapperDomainToEntity.mapToEntity(domain, CustomerEntity.class);
            customerRepository.save(entity);
        } catch (ExceptionHortalsoft exceptionHortalsoft) {
            throw exceptionHortalsoft;
        } catch (Exception exception) {
            throw new ExceptionHortalsoft("Ha ocurrido un error inesperado creando el cliente", 500, layer, exception);
        }

    }
}
