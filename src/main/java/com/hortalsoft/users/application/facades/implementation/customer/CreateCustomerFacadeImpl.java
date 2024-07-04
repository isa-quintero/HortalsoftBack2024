package com.hortalsoft.users.application.facades.implementation.customer;

import com.hortalsoft.crosscutting.util.ExceptionHandlingAspect;
import com.hortalsoft.users.application.dto.CustomerDTO;
import com.hortalsoft.users.application.facades.facade.customer.CreateCustomerFacade;
import com.hortalsoft.users.application.mapper.MapperDTOToDomain;
import com.hortalsoft.users.domain.domain.Customer;
import com.hortalsoft.users.domain.port.input.customer.CreateCustomerUseCase;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CreateCustomerFacadeImpl implements CreateCustomerFacade {

    MapperDTOToDomain<CustomerDTO, Customer> mapperDTOToDomain = new MapperDTOToDomain<>();

    private final CreateCustomerUseCase createCustomerUseCase;
    private final ExceptionHandlingAspect exceptionHandlingAspect;

    public CreateCustomerFacadeImpl(CreateCustomerUseCase createCustomerUseCase, ExceptionHandlingAspect exceptionHandlingAspect) {
        this.createCustomerUseCase = createCustomerUseCase;
        this.exceptionHandlingAspect = exceptionHandlingAspect;
    }


    @Override
    public void execute(CustomerDTO dto) {
        try {
            Customer domain = mapperDTOToDomain.mapToDomain(dto, Customer.class);
            createCustomerUseCase.execute(domain);
        } catch (Exception exception) {
            exceptionHandlingAspect.exceptionsApplication(exception);
        }
    }


}
