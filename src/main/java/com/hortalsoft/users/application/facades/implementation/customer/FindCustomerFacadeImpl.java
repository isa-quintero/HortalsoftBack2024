package com.hortalsoft.users.application.facades.implementation.customer;

import com.hortalsoft.crosscutting.util.ExceptionHortalsoft;
import com.hortalsoft.crosscutting.util.Layer;
import com.hortalsoft.users.application.dto.CustomerDTO;
import com.hortalsoft.users.application.facades.facade.customer.FindCustomerFacade;
import com.hortalsoft.users.application.mapper.MapperDTOToDomain;
import com.hortalsoft.users.application.mapper.MapperDomainToDto;
import com.hortalsoft.users.domain.domain.Customer;
import com.hortalsoft.users.domain.port.input.customer.FindCustomerUseCase;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class FindCustomerFacadeImpl implements FindCustomerFacade {
    MapperDTOToDomain<CustomerDTO, Customer> mapperDTOToDomain = new MapperDTOToDomain<>();
    MapperDomainToDto<Customer, CustomerDTO> mapperDomainToDto = new MapperDomainToDto<>();
    private final FindCustomerUseCase useCase;
    private static final Layer layer = Layer.APPLICATION;

    public FindCustomerFacadeImpl(FindCustomerUseCase useCase) {
        this.useCase = useCase;
    }

    @Override
    public CustomerDTO execute(CustomerDTO dto) {
        try {
            Customer domain = mapperDTOToDomain.mapToDomain(dto, Customer.class);
            return mapperDomainToDto.mapToDto(useCase.execute(domain), CustomerDTO.class);
        } catch (ExceptionHortalsoft exceptionHortalsoft) {
            throw exceptionHortalsoft;
        } catch (Exception exception) {
            throw new ExceptionHortalsoft("ha ocurrido un error inesperado", 500, layer, exception);
        }
    }
}
