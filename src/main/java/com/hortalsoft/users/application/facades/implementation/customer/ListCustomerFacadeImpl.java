package com.hortalsoft.users.application.facades.implementation.customer;

import com.hortalsoft.crosscutting.util.ExceptionHortalsoft;
import com.hortalsoft.crosscutting.util.Layer;
import com.hortalsoft.users.application.dto.CustomerDTO;
import com.hortalsoft.users.application.facades.facade.customer.ListCustomerFacade;
import com.hortalsoft.users.application.mapper.MapperDomainToDto;
import com.hortalsoft.users.domain.domain.Customer;
import com.hortalsoft.users.domain.port.input.customer.ListCustomerUseCase;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ListCustomerFacadeImpl implements ListCustomerFacade {

    MapperDomainToDto<Customer, CustomerDTO> mapperDomainToDto = new MapperDomainToDto<>();
    private final ListCustomerUseCase useCase;
    private static final Layer layer = Layer.APPLICATION;

    public ListCustomerFacadeImpl(ListCustomerUseCase useCase) {
        this.useCase = useCase;
    }

    @Override
    public List<CustomerDTO> execute() {
        try {
            return mapperDomainToDto.mapToDtoList(useCase.execute(), CustomerDTO.class);
        } catch (ExceptionHortalsoft exceptionHortalsoft) {
            throw exceptionHortalsoft;
        } catch (Exception exception) {
            throw new ExceptionHortalsoft("Ha ocurrido un error inesperado", 500, layer, exception);
        }
    }
}
