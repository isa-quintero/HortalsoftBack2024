package com.hortalsoft.users.domain.port.usecase.customer;

import com.hortalsoft.crosscutting.util.ExceptionHortalsoft;
import com.hortalsoft.crosscutting.util.Layer;
import com.hortalsoft.users.domain.domain.Customer;
import com.hortalsoft.users.domain.entity.CustomerEntity;
import com.hortalsoft.users.domain.mapper.MapperDomainToEntity;
import com.hortalsoft.users.domain.port.input.customer.CreateCustomerUseCase;
import com.hortalsoft.users.domain.repository.CustomerRepository;
import com.hortalsoft.users.domain.repository.UserRepository;
import com.hortalsoft.users.domain.specification.user.UniqueIdNumberSpec;
import org.springframework.stereotype.Service;

@Service
public class CreateCustomerService  implements CreateCustomerUseCase {
    private static final Layer layer = Layer.DOMAIN;
    private final UserRepository userRepository;
    private final CustomerRepository customerRepository;
    MapperDomainToEntity<Customer, CustomerEntity> mapperDomainToEntity = new MapperDomainToEntity<>();

    public CreateCustomerService(UserRepository userRepository, CustomerRepository customerRepository) {
        this.userRepository = userRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public void execute(Customer domain) {
        try {
            UniqueIdNumberSpec uniqueIdNumberSpec = new UniqueIdNumberSpec(userRepository);
            if (!uniqueIdNumberSpec.isSatisfiedBy(domain.getIdNumber())) {
                CustomerEntity entity = mapperDomainToEntity.mapToEntity(domain, CustomerEntity.class);
                customerRepository.save(entity);
            } else{
                throw new ExceptionHortalsoft("El usuario ya existe", 6001, layer);
            }

        } catch (ExceptionHortalsoft exceptionHortalsoft) {
            throw exceptionHortalsoft;
        } catch (Exception exception) {
            throw new ExceptionHortalsoft("Ha ocurrido un error inesperado creando el cliente", 500, layer, exception);
        }

    }
}
