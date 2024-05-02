package com.hortalsoft.products.infrastructure.adapter.inbound.controller;

import com.hortalsoft.products.application.dto.OfferDTO;
import com.hortalsoft.products.application.facades.facade.offer.CreateOfferFacade;
import com.hortalsoft.products.application.facades.facade.offer.DisableOfferFacade;
import com.hortalsoft.products.application.facades.facade.offer.FindOfferFacade;
import com.hortalsoft.products.application.facades.facade.offer.ListOfferFacade;
import com.hortalsoft.util.ExceptionHandlingAspect;
import com.hortalsoft.util.ExceptionHortalsoft;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping("/offers")
public class OfferController {

    private final CreateOfferFacade facadeCreate;
    private final DisableOfferFacade facadeDelete;
    private final FindOfferFacade facadeFind;
    private final ListOfferFacade facadeList;
    private final ExceptionHandlingAspect exceptionHandlingAspect;
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);


    public OfferController(CreateOfferFacade facade, DisableOfferFacade facadeDelete, FindOfferFacade facadeFind, ListOfferFacade facadeList, ExceptionHandlingAspect exceptionHandlingAspect) {
        this.facadeCreate = facade;
        this.facadeDelete = facadeDelete;
        this.facadeFind = facadeFind;
        this.facadeList = facadeList;
        this.exceptionHandlingAspect = exceptionHandlingAspect;
    }
    @PostMapping
    public ResponseEntity<OfferDTO> createOffer(@RequestBody OfferDTO input){
        try{
            facadeCreate.execute(input);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Error e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @DeleteMapping
    public ResponseEntity<OfferDTO> disableOffer(@RequestParam (name = "id") int id){
        try{
            LocalDate date=LocalDate.now();
            OfferDTO offer = new OfferDTO(id,0,0,"",0,0,date,date,0,"");
            facadeDelete.execute(offer);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Error e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @GetMapping
    public ResponseEntity<?> findOffer(@RequestParam (name = "id") int id){
        try{
            OfferDTO offer = new OfferDTO(id,0,0,"",0,0,LocalDate.now(),LocalDate.now(),0,"");
            OfferDTO result=facadeFind.execute(offer);
            logger.info("Oferta encontrada");
            return ResponseEntity.ok().body(result);
        }
        catch (Exception e){
            return exceptionHandlingAspect.exceptionsInfrastructure(e);
        }
    }

    @GetMapping("/list")
    public ResponseEntity<?> listPriceRanges(){
        try{
            List<OfferDTO> offerDTOS = facadeList.execute();
            return new ResponseEntity<>(offerDTOS, HttpStatus.OK);
        }
        catch (ExceptionHortalsoft e){
            return exceptionHandlingAspect.exceptionsInfrastructure(e);
        }
    }
}
