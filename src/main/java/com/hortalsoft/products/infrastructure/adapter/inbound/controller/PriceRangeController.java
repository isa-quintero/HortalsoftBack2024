package com.hortalsoft.products.infrastructure.adapter.inbound.controller;

import com.hortalsoft.products.application.dto.PriceRangeDTO;
import com.hortalsoft.products.application.facades.facade.pricerange.*;
import com.hortalsoft.crosscutting.util.ExceptionHandlingAspect;
import com.hortalsoft.crosscutting.util.ExceptionHortalsoft;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("/inventory")
public class PriceRangeController {

    private final CreatePriceRangeFacade facadeCreate;
    private final DeletePriceRangeFacade facadeDelete;
    private final FindPriceRangeFacade facadeFind;
    private final ListPricesRangesByAssociationFacade facadeListByAssociations;
    private final ListPricesRangesFacade facadeList;
    private final ExceptionHandlingAspect exceptionHandlingAspect;
    private static final Logger logger = LoggerFactory.getLogger(PriceRangeController.class);

    public PriceRangeController(CreatePriceRangeFacade facadeCreate, DeletePriceRangeFacade facadeDelete, FindPriceRangeFacade facadeFind, ListPricesRangesByAssociationFacade facadeListByAssociations, ListPricesRangesFacade facadeList, ExceptionHandlingAspect exceptionHandlingAspect) {
        this.facadeCreate = facadeCreate;
        this.facadeDelete = facadeDelete;
        this.facadeFind = facadeFind;
        this.facadeListByAssociations = facadeListByAssociations;
        this.facadeList = facadeList;
        this.exceptionHandlingAspect = exceptionHandlingAspect;
    }
    @PostMapping("/price-ranges")
    public ResponseEntity<Object> createPriceRange(@RequestBody PriceRangeDTO input){
        try{
            facadeCreate.execute(input);
            logger.info("Rango de precios creado");
            return ResponseEntity.ok().build();
        }
        catch (Exception e){
            return exceptionHandlingAspect.exceptionsInfrastructure(e);
        }
    }

    @DeleteMapping("/price-ranges/{id}")
    public ResponseEntity<Object> deletePriceRange(@PathVariable (name = "id") int id){
        try{
            PriceRangeDTO priceRange = new PriceRangeDTO(id,0,0,0,0,LocalDateTime.now(), LocalDateTime.now(),true);
            facadeDelete.execute(priceRange);
            logger.info("Rango de precio eliminado");
            return ResponseEntity.ok().build();
        }
        catch (Exception e){
            return exceptionHandlingAspect.exceptionsInfrastructure(e);
        }
    }

    @GetMapping("/price-ranges/{id}")
    public ResponseEntity<Object> findPriceRange(@PathVariable (name = "id") int id){
        try {
            PriceRangeDTO priceRange = new PriceRangeDTO(id,0,0,0,0,LocalDateTime.now(), LocalDateTime.now(),true);
            PriceRangeDTO priceRangeDTO = facadeFind.execute(priceRange);
            logger.info("Rango de precio encontrado");
            return ResponseEntity.ok().body(priceRangeDTO);
        }
        catch (ExceptionHortalsoft e){
            return exceptionHandlingAspect.exceptionsInfrastructure(e);
        }

    }
    @GetMapping("/price-ranges-associations/{id}")
    public ResponseEntity<Object> listPriceRangesByAssociation(@PathVariable (name = "id") int id){
        try{
            PriceRangeDTO priceRange = new PriceRangeDTO(id,0,id,0,0,LocalDateTime.now(), LocalDateTime.now(),true);
            List<PriceRangeDTO> priceRangeDTOS = facadeListByAssociations.execute(priceRange);
            return new ResponseEntity<>(priceRangeDTOS, HttpStatus.OK);
        }
        catch (ExceptionHortalsoft e){
            return exceptionHandlingAspect.exceptionsInfrastructure(e);
        }
    }

    @GetMapping("/price-ranges")
    public ResponseEntity<Object> listPriceRanges(){
        try{
            List<PriceRangeDTO> priceRangeDTOS = facadeList.execute();
            return new ResponseEntity<>(priceRangeDTOS, HttpStatus.OK);
        }
        catch (ExceptionHortalsoft e){
            return exceptionHandlingAspect.exceptionsInfrastructure(e);
        }
    }
}
