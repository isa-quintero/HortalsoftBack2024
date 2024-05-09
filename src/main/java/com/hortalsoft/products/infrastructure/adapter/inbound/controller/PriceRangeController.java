package com.hortalsoft.products.infrastructure.adapter.inbound.controller;

import com.hortalsoft.products.application.dto.PriceRangeDTO;
import com.hortalsoft.products.application.facades.facade.pricerange.CreatePriceRangeFacade;
import com.hortalsoft.products.application.facades.facade.pricerange.DeletePriceRangeFacade;
import com.hortalsoft.products.application.facades.facade.pricerange.FindPriceRangeFacade;
import com.hortalsoft.products.application.facades.facade.pricerange.ListPricesRangesFacade;
import com.hortalsoft.crosscutting.util.ExceptionHandlingAspect;
import com.hortalsoft.crosscutting.util.ExceptionHortalsoft;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping("/inventory")
public class PriceRangeController {

    private final CreatePriceRangeFacade facadeCreate;
    private final DeletePriceRangeFacade facadeDelete;
    private final FindPriceRangeFacade facadeFind;
    private final ListPricesRangesFacade facadeList;
    private final ExceptionHandlingAspect exceptionHandlingAspect;
    private static final Logger logger = LoggerFactory.getLogger(PriceRangeController.class);

    public PriceRangeController(CreatePriceRangeFacade facadeCreate, DeletePriceRangeFacade facadeDelete, FindPriceRangeFacade facadeFind, ListPricesRangesFacade facadeList, ExceptionHandlingAspect exceptionHandlingAspect) {
        this.facadeCreate = facadeCreate;
        this.facadeDelete = facadeDelete;
        this.facadeFind = facadeFind;
        this.facadeList = facadeList;
        this.exceptionHandlingAspect = exceptionHandlingAspect;
    }
    @PostMapping("/price-range")
    public ResponseEntity<?> createPriceRange(@RequestBody PriceRangeDTO input){
        try{
            facadeCreate.execute(input);
            logger.info("Rango de precios creado");
            return ResponseEntity.ok().build();
        }
        catch (Exception e){
            return exceptionHandlingAspect.exceptionsInfrastructure(e);
        }
    }

    @DeleteMapping("/price-range/{id}")
    public ResponseEntity<?> deletePriceRange(@PathVariable (name = "id") int id){
        try{
            PriceRangeDTO priceRange = new PriceRangeDTO(id,0,0,0,0,LocalDate.now(), LocalDate.now(),0);
            facadeDelete.execute(priceRange);
            logger.info("Rango de precio eliminado");
            return ResponseEntity.ok().build();
        }
        catch (Exception e){
            return exceptionHandlingAspect.exceptionsInfrastructure(e);
        }
    }

    @GetMapping("/price-range/{id}")
    public ResponseEntity<?> findPriceRange(@PathVariable (name = "id") int id){
        try {
            PriceRangeDTO priceRange = new PriceRangeDTO(id,0,0,0,0,LocalDate.now(), LocalDate.now(),0);
            PriceRangeDTO priceRangeDTO = facadeFind.execute(priceRange);
            logger.info("Rango de precio encontrado");
            return ResponseEntity.ok().body(priceRangeDTO);
        }
        catch (ExceptionHortalsoft e){
            return exceptionHandlingAspect.exceptionsInfrastructure(e);
        }

    }

    @GetMapping("/price-ranges")
    public ResponseEntity<?> listPriceRanges(){
        try{
            List<PriceRangeDTO> priceRangeDTOS = facadeList.execute();
            return new ResponseEntity<>(priceRangeDTOS, HttpStatus.OK);
        }
        catch (ExceptionHortalsoft e){
            return exceptionHandlingAspect.exceptionsInfrastructure(e);
        }
    }
}
