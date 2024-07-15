package com.hortalsoft.users.infrastructure.adapter.inbound.controller;

import com.hortalsoft.crosscutting.util.ExceptionHandlingAspect;
import com.hortalsoft.users.application.dto.UserDTO;
import com.hortalsoft.users.application.facades.facade.user.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.hortalsoft.users.util.UserType.CUSTOMER;

@RestController
@RequestMapping("/profiles")
public class UserController {
    public static final String USUARIO_ENCONTRADO = "Usuario encontrado";
    private final FindUserFacadeEmail facadeFindByEmail;
    private final ExceptionHandlingAspect exceptionHandlingAspect;
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    public UserController( FindUserFacadeEmail facadeFindByEmail, ExceptionHandlingAspect exceptionHandlingAspect) {
        this.facadeFindByEmail = facadeFindByEmail;
        this.exceptionHandlingAspect = exceptionHandlingAspect;
    }
    @GetMapping("/users-emails/{email}")
    public ResponseEntity<Object> findUserByEmail(@PathVariable(name = "email") String email) {
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

    @GetMapping("/users-roles/{email}")
    public ResponseEntity<Object> findRoleByEmail(@PathVariable(name = "email") String email) {
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
}
