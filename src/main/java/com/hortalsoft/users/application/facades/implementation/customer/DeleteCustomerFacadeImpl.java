package com.hortalsoft.users.application.facades.implementation.customer;

import com.hortalsoft.crosscutting.util.ExceptionHandlingAspect;
import com.hortalsoft.users.application.dto.CustomerDTO;
import com.hortalsoft.users.application.facades.facade.customer.DeleteCustomerFacade;
import com.hortalsoft.users.application.mapper.MapperDTOToDomain;
import com.hortalsoft.users.domain.domain.Customer;
import com.hortalsoft.users.domain.port.input.customer.DeleteCustomerUseCase;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class DeleteCustomerFacadeImpl implements DeleteCustomerFacade {
    MapperDTOToDomain<CustomerDTO, Customer> mapperDTOToDomain = new MapperDTOToDomain<>();
    private final DeleteCustomerUseCase useCase;
    private final ExceptionHandlingAspect exceptionHandlingAspect;

    public DeleteCustomerFacadeImpl(DeleteCustomerUseCase useCase, ExceptionHandlingAspect exceptionHandlingAspect) {
        this.useCase = useCase;

        this.exceptionHandlingAspect = exceptionHandlingAspect;
    }

    @Override
    public void execute(CustomerDTO dto) {
        try {
            Customer domain = mapperDTOToDomain.mapToDomain(dto, Customer.class);
            useCase.execute(domain);
        } catch (Exception exception) {
            exceptionHandlingAspect.exceptionsApplication(exception);
        }
    }
}
