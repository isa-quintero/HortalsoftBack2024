package com.hortalsoft.users.infrastructure.adapter.inbound.controller;

import com.hortalsoft.crosscutting.util.ExceptionHandlingAspect;
import com.hortalsoft.crosscutting.util.ExceptionHortalsoft;
import com.hortalsoft.users.application.dto.UserDTO;
import com.hortalsoft.users.application.facades.facade.user.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profiles")
public class UserController {
    private final CreateUserFacade facadeCreate;
    private final DeleteUserFacade facadeDelete;
    private final FindUserFacade facadeFind;
    private final FindUserFacadeEmail facadeFindByEmail;
    private final ListUserFacade facadeList;
    private final ExceptionHandlingAspect exceptionHandlingAspect;
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);


    public UserController(CreateUserFacade facadeCreate, DeleteUserFacade facadeDelete, FindUserFacade facadeFind, FindUserFacadeEmail facadeFindByEmail, ListUserFacade facadeList, ExceptionHandlingAspect exceptionHandlingAspect) {
        this.facadeCreate = facadeCreate;
        this.facadeDelete = facadeDelete;
        this.facadeFind = facadeFind;
        this.facadeFindByEmail = facadeFindByEmail;
        this.facadeList = facadeList;

        this.exceptionHandlingAspect = exceptionHandlingAspect;
    }

    @PostMapping("/user")
    public ResponseEntity<Object> createUser(@RequestBody UserDTO input) {
        try {
            facadeCreate.execute(input);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return exceptionHandlingAspect.exceptionsInfrastructure(e);

        }
    }

    @GetMapping("/users")
    public ResponseEntity<Object> listUsers() {
        try {
            List<UserDTO> userDTOS = facadeList.execute();
            return new ResponseEntity<>(userDTOS, HttpStatus.OK);
        } catch (ExceptionHortalsoft e) {
            return exceptionHandlingAspect.exceptionsInfrastructure(e);
        }
    }
}
