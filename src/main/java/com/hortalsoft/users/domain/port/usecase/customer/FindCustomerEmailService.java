package com.hortalsoft.users.domain.port.usecase.customer;


import com.hortalsoft.crosscutting.util.ExceptionHortalsoft;
import com.hortalsoft.crosscutting.util.Layer;
import com.hortalsoft.users.domain.domain.Customer;
import com.hortalsoft.users.domain.domain.User;
import com.hortalsoft.users.domain.mapper.MapperUserToCustomer;
import com.hortalsoft.users.domain.port.input.customer.FindCustomerEmailUseCase;
import com.hortalsoft.users.domain.port.usecase.user.FindUserEmailService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class FindCustomerEmailService implements FindCustomerEmailUseCase {

    private static final Layer layer = Layer.DOMAIN;
    private final FindUserEmailService findUserEmailService;
    MapperUserToCustomer<User, Customer> mapperUserToCustomer = new MapperUserToCustomer<>();

    @Autowired
    public FindCustomerEmailService(FindUserEmailService findUserEmailService) {
        this.findUserEmailService = findUserEmailService;
    }


    @Override
    public Customer execute(Customer domain) {
        try {
            return mapperUserToCustomer.mapToCustomer(findUserEmailService.execute(domain), Customer.class);
        } catch (ExceptionHortalsoft exceptionHortalsoft) {
            throw exceptionHortalsoft;
        } catch (Exception exception) {
            throw new ExceptionHortalsoft("Ha ocurrido un error inesperado buscando el usuario" , 500, layer, exception);
        }
    }
}
