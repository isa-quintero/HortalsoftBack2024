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

import static com.hortalsoft.users.util.UserType.CUSTOMER;

@RestController
@RequestMapping("/profiles")
public class UserController {
    public static final String USUARIO_ENCONTRADO = "Usuario encontrado";
    private final FindUserFacade facadeFind;
    private final FindUserFacadeEmail facadeFindByEmail;
    private final ListUserFacade facadeList;
    private final ExceptionHandlingAspect exceptionHandlingAspect;
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);


    public UserController( FindUserFacade facadeFind, FindUserFacadeEmail facadeFindByEmail, ListUserFacade facadeList, ExceptionHandlingAspect exceptionHandlingAspect) {
        this.facadeFind = facadeFind;
        this.facadeFindByEmail = facadeFindByEmail;
        this.facadeList = facadeList;

        this.exceptionHandlingAspect = exceptionHandlingAspect;
    }
    @GetMapping("/users/{id}")
    public ResponseEntity<Object> findUser(@PathVariable(name = "id") int id) {
        try {
            UserDTO userDTO = new UserDTO(id, 0, 0, "", 0, "", "", "", CUSTOMER){

            };
            UserDTO result = facadeFind.execute(userDTO);
            logger.info(USUARIO_ENCONTRADO);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return exceptionHandlingAspect.exceptionsInfrastructure(e);
        }
    }
    @GetMapping("/users-emails/{email}")
    public ResponseEntity<Object> findAssociationByEmail(@PathVariable(name = "email") String email) {
        try {
            UserDTO user = new UserDTO(0, 0, 0, "", 0, email, "", "",CUSTOMER) {
            };
            UserDTO result = facadeFindByEmail.execute(user);
            logger.info(USUARIO_ENCONTRADO);
            return ResponseEntity.ok().body(result);
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
