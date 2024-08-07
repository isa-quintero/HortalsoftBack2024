package com.hortalsoft.users.infrastructure.adapter.inbound.controller;

import com.hortalsoft.crosscutting.util.ExceptionHandlingAspect;
import com.hortalsoft.crosscutting.util.ExceptionHortalsoft;
import com.hortalsoft.users.application.dto.AssociationDTO;
import com.hortalsoft.users.application.facades.facade.association.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/profiles")
public class AssociationController {
    public static final String USUARIO_ENCONTRADO = "Usuario encontrado";
    private final CreateAssociationFacade facadeCreate;
    private final DeleteAssociationFacade facadeDelete;
    private final FindAssociationFacade facadeFind;
    private final FindAssociationFacadeEmail facadeFindByEmail;
    private final FindAssociationIdNumberFacade facadeFindByIdNumber;
    private final ListAssociationFacade facadeList;
    private final ExceptionHandlingAspect exceptionHandlingAspect;
    private static final Logger logger = LoggerFactory.getLogger(AssociationController.class);

    public AssociationController(CreateAssociationFacade facadeCreate, DeleteAssociationFacade facadeDelete, FindAssociationFacade facadeFind, FindAssociationFacadeEmail facadeFindByEmail, FindAssociationIdNumberFacade facadeFindByIdNumber, ListAssociationFacade facadeList, ExceptionHandlingAspect exceptionHandlingAspect) {
        this.facadeCreate = facadeCreate;
        this.facadeDelete = facadeDelete;
        this.facadeFind = facadeFind;
        this.facadeFindByEmail = facadeFindByEmail;
        this.facadeFindByIdNumber = facadeFindByIdNumber;
        this.facadeList = facadeList;
        this.exceptionHandlingAspect = exceptionHandlingAspect;
    }


    @PostMapping("/associations")
    public ResponseEntity<Object> createAssociation(@RequestBody AssociationDTO input) {
        try {
            facadeCreate.execute(input);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return exceptionHandlingAspect.exceptionsInfrastructure(e);

        }
    }

    @DeleteMapping("/associations/{id}")
    public ResponseEntity<Object> disableAssociation(@PathVariable(name = "id") int id) {
        try {
            AssociationDTO association = new AssociationDTO(id,0,0,"",0,"","","","");
            facadeDelete.execute(association);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return exceptionHandlingAspect.exceptionsInfrastructure(e);
        }
    }

    @GetMapping("/associations/{id}")
    public ResponseEntity<Object> findAssociation(@PathVariable(name = "id") int id) {
        try {
            AssociationDTO association = new AssociationDTO(id,0,0,"",0,"","","","");
            AssociationDTO result = facadeFind.execute(association);
            logger.info(USUARIO_ENCONTRADO);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return exceptionHandlingAspect.exceptionsInfrastructure(e);
        }
    }
    @GetMapping("/associations-emails/{email}")
    public ResponseEntity<Object> findAssociationByEmail(@PathVariable(name = "email") String email) {
        try {
            AssociationDTO user = new AssociationDTO(0,0,0,"",0,email,"","","");
            AssociationDTO result = facadeFindByEmail.execute(user);
            logger.info(USUARIO_ENCONTRADO);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return exceptionHandlingAspect.exceptionsInfrastructure(e);
        }
    }
    @GetMapping("/associations-id/{idNumber}")
    public ResponseEntity<Object> findAssociationIdNumber(@PathVariable(name = "idNumber") Long idNumber) {
        try {
            AssociationDTO user = new AssociationDTO(0,0,idNumber,"",0,"","","","");
            AssociationDTO result = facadeFindByIdNumber.execute(user);
            logger.info(USUARIO_ENCONTRADO);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return exceptionHandlingAspect.exceptionsInfrastructure(e);
        }
    }

    @GetMapping("/associations")
    public ResponseEntity<Object> listAssociations() {
        try {
            List<AssociationDTO> associationDTOS = facadeList.execute();
            return new ResponseEntity<>(associationDTOS, HttpStatus.OK);
        } catch (ExceptionHortalsoft e) {
            return exceptionHandlingAspect.exceptionsInfrastructure(e);
        }
    }
}
