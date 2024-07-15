package com.hortalsoft.users.infrastructure.adapter.inbound.controller;

import com.hortalsoft.crosscutting.util.ExceptionHandlingAspect;
import com.hortalsoft.crosscutting.util.ExceptionHortalsoft;
import com.hortalsoft.users.application.dto.FarmerDTO;
import com.hortalsoft.users.application.facades.facade.farmer.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profiles")
public class FarmerController {
    public static final String USUARIO_ENCONTRADO = "Usuario encontrado";
    private final CreateFarmerFacade facadeCreate;
    private final DeleteFarmerFacade facadeDelete;
    private final FindFarmerFacade facadeFind;
    private final FindFarmerFacadeEmail facadeFindByEmail;
    private final FindFarmerIdNumberFacade facadeFindByIdNumber;
    private final ListFarmerFacade facadeList;
    private final ExceptionHandlingAspect exceptionHandlingAspect;
    private static final Logger logger = LoggerFactory.getLogger(FarmerController.class);

    public FarmerController(CreateFarmerFacade facadeCreate, DeleteFarmerFacade facadeDelete, FindFarmerFacade facadeFind, FindFarmerFacadeEmail facadeFindByEmail, FindFarmerIdNumberFacade facadeFindByIdNumber, ListFarmerFacade facadeList, ExceptionHandlingAspect exceptionHandlingAspect) {
        this.facadeCreate = facadeCreate;
        this.facadeDelete = facadeDelete;
        this.facadeFind = facadeFind;
        this.facadeFindByEmail = facadeFindByEmail;
        this.facadeFindByIdNumber = facadeFindByIdNumber;
        this.facadeList = facadeList;
        this.exceptionHandlingAspect = exceptionHandlingAspect;
    }


    @PostMapping("/farmers")
    public ResponseEntity<Object> createFarmer(@RequestBody FarmerDTO input) {
        try {
            facadeCreate.execute(input);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return exceptionHandlingAspect.exceptionsInfrastructure(e);

        }
    }

    @DeleteMapping("/farmers/{id}")
    public ResponseEntity<Object> disableFarmer(@PathVariable(name = "id") int id) {
        try {
            FarmerDTO farmer = new FarmerDTO(id,0,0,"",0,"","","", 0);
            facadeDelete.execute(farmer);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return exceptionHandlingAspect.exceptionsInfrastructure(e);
        }
    }

    @GetMapping("/farmers/{id}")
    public ResponseEntity<Object> findFarmer(@PathVariable(name = "id") int id) {
        try {
            FarmerDTO farmer = new FarmerDTO(id,0,0,"",0,"","","",0);
            FarmerDTO result = facadeFind.execute(farmer);
            logger.info(USUARIO_ENCONTRADO);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return exceptionHandlingAspect.exceptionsInfrastructure(e);
        }
    }
    @GetMapping("/farmers-emails/{email}")
    public ResponseEntity<Object> findFarmerByEmail(@PathVariable(name = "email") String email) {
        try {
            FarmerDTO farmer = new FarmerDTO(0,0,0,"",0,email,"","",0);
            FarmerDTO result = facadeFindByEmail.execute(farmer);
            logger.info(USUARIO_ENCONTRADO);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return exceptionHandlingAspect.exceptionsInfrastructure(e);
        }
    }
    @GetMapping("/farmers-id/{idNumber}")
    public ResponseEntity<Object> findFarmerByIdNumber(@PathVariable(name = "idNumber") Long idNumber) {
        try {
            FarmerDTO farmer = new FarmerDTO(0,0,idNumber,"",0,"","","",0);
            FarmerDTO result = facadeFindByIdNumber.execute(farmer);
            logger.info(USUARIO_ENCONTRADO);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return exceptionHandlingAspect.exceptionsInfrastructure(e);
        }
    }

    @GetMapping("/farmers")
    public ResponseEntity<Object> listFarmer() {
        try {
            List<FarmerDTO> farmerDTOS = facadeList.execute();
            return new ResponseEntity<>(farmerDTOS, HttpStatus.OK);
        } catch (ExceptionHortalsoft e) {
            return exceptionHandlingAspect.exceptionsInfrastructure(e);
        }
    }
}
