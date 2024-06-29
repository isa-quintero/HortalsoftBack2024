package com.hortalsoft.users.infrastructure.adapter.inbound.controller;

import com.hortalsoft.crosscutting.util.ExceptionHandlingAspect;
import com.hortalsoft.crosscutting.util.ExceptionHortalsoft;
import com.hortalsoft.products.infrastructure.adapter.inbound.controller.OfferController;
import com.hortalsoft.users.application.dto.UserDTO;
import com.hortalsoft.users.application.facades.facade.user.CreateUserFacade;
import com.hortalsoft.users.application.facades.facade.user.DeleteUserFacade;
import com.hortalsoft.users.application.facades.facade.user.FindUserFacade;
import com.hortalsoft.users.application.facades.facade.user.ListUserFacade;
import com.hortalsoft.users.util.UserType;
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
    private final ListUserFacade facadeList;
    private final ExceptionHandlingAspect exceptionHandlingAspect;
    private static final Logger logger = LoggerFactory.getLogger(OfferController.class);


    public UserController(CreateUserFacade facadeCreate, DeleteUserFacade facadeDelete, FindUserFacade facadeFind, ListUserFacade facadeList, ExceptionHandlingAspect exceptionHandlingAspect) {
        this.facadeCreate = facadeCreate;
        this.facadeDelete = facadeDelete;
        this.facadeFind = facadeFind;
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

    @DeleteMapping("/user/{id}")
    public ResponseEntity<Object> disableUser(@PathVariable(name = "id") int id) {
        try {
            UserDTO user = new UserDTO(id,"",0,"",0,"","","", UserType.FARMER);
            facadeDelete.execute(user);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return exceptionHandlingAspect.exceptionsInfrastructure(e);
        }
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<Object> findUser(@PathVariable(name = "id") int id) {
        try {
            UserDTO user = new UserDTO(id,"",0,"",0,"","","", UserType.FARMER);
            UserDTO result = facadeFind.execute(user);
            logger.info("Usuario encontrado");
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
