package com.hortalsoft.users.domain.port.usecase.customer;


import com.hortalsoft.crosscutting.util.ExceptionHortalsoft;
import com.hortalsoft.crosscutting.util.Layer;
import com.hortalsoft.users.domain.domain.Customer;
import com.hortalsoft.users.domain.port.input.customer.DeleteCustomerUseCase;
import com.hortalsoft.users.domain.repository.CustomerRepository;
import com.hortalsoft.users.domain.repository.UserRepository;
import com.hortalsoft.users.domain.specification.user.UserExistByIdSpec;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class DeleteCustomerService implements DeleteCustomerUseCase {

    private final CustomerRepository customerRepository;
    private final UserRepository userRepository;
    private static final Layer layer = Layer.DOMAIN;

    @Autowired
    public DeleteCustomerService(CustomerRepository customerRepository, UserRepository userRepository) {
        this.customerRepository = customerRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void execute(Customer domain) {
        try {
            UserExistByIdSpec userExistByIdSpec = new UserExistByIdSpec(userRepository);
            if (userExistByIdSpec.isSatisfiedBy(domain.getIdUser())) {
                customerRepository.deleteById(domain.getIdUser());
            } else{
                throw new ExceptionHortalsoft("Usuario no encontrada", 6001, layer);
            }
        } catch (ExceptionHortalsoft exceptionHortalsoft) {
            throw exceptionHortalsoft;
        } catch (Exception exception) {
            throw new ExceptionHortalsoft("Ha ocurrido un error inesperado eliminando el cliente", 500, layer, exception);
        }
    }
}
