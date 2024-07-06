package com.hortalsoft.users.infrastructure.adapter.inbound.controller;

import com.hortalsoft.crosscutting.util.ExceptionHandlingAspect;
import com.hortalsoft.crosscutting.util.ExceptionHortalsoft;
import com.hortalsoft.users.application.dto.CustomerDTO;
import com.hortalsoft.users.application.facades.facade.customer.*;
import com.hortalsoft.users.util.UserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/profiles")
public class CustomerController {
    public static final String USUARIO_ENCONTRADO = "Usuario encontrado";
    private final CreateCustomerFacade facadeCreate;
    private final DeleteCustomerFacade facadeDelete;
    private final FindCustomerFacade facadeFind;
    private final FindCustomerFacadeEmail facadeFindByEmail;
    private final ListCustomerFacade facadeList;
    private final ExceptionHandlingAspect exceptionHandlingAspect;
    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    public CustomerController(CreateCustomerFacade facadeCreate, DeleteCustomerFacade facadeDelete, FindCustomerFacade facadeFind, FindCustomerFacadeEmail facadeFindByEmail, ListCustomerFacade facadeList, ExceptionHandlingAspect exceptionHandlingAspect) {
        this.facadeCreate = facadeCreate;
        this.facadeDelete = facadeDelete;
        this.facadeFind = facadeFind;
        this.facadeFindByEmail = facadeFindByEmail;
        this.facadeList = facadeList;
        this.exceptionHandlingAspect = exceptionHandlingAspect;
    }


    @PostMapping("/customer")
    public ResponseEntity<Object> createCustomer(@RequestBody CustomerDTO input) {
        try {
            facadeCreate.execute(input);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return exceptionHandlingAspect.exceptionsInfrastructure(e);

        }
    }

    @DeleteMapping("/customer/{id}")
    public ResponseEntity<Object> disableCustomer(@PathVariable(name = "id") int id) {
        try {
            CustomerDTO customer = new CustomerDTO(id,0,0,"",0,"","","");
            facadeDelete.execute(customer);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return exceptionHandlingAspect.exceptionsInfrastructure(e);
        }
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<Object> findCustomer(@PathVariable(name = "id") int id) {
        try {
            CustomerDTO customer = new CustomerDTO(id,0,0,"",0,"","","");
            CustomerDTO result = facadeFind.execute(customer);
            logger.info(USUARIO_ENCONTRADO);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return exceptionHandlingAspect.exceptionsInfrastructure(e);
        }
    }
    @GetMapping("/customer/{email}")
    public ResponseEntity<Object> findCustomerByEmail(@PathVariable(name = "email") String email) {
        try {
            CustomerDTO customer = new CustomerDTO(0,0,0,"",0,email,"","");
            CustomerDTO result = facadeFindByEmail.execute(customer);
            logger.info(USUARIO_ENCONTRADO);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return exceptionHandlingAspect.exceptionsInfrastructure(e);
        }
    }

    @GetMapping("/customers")
    public ResponseEntity<Object> listCustomers() {
        try {
            List<CustomerDTO> customerDTOS = facadeList.execute();
            return new ResponseEntity<>(customerDTOS, HttpStatus.OK);
        } catch (ExceptionHortalsoft e) {
            return exceptionHandlingAspect.exceptionsInfrastructure(e);
        }
    }
}
