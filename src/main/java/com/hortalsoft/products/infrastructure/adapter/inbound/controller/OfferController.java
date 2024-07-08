package com.hortalsoft.products.infrastructure.adapter.inbound.controller;

import com.hortalsoft.products.application.dto.OfferDTO;
import com.hortalsoft.products.application.facades.facade.offer.*;
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
public class OfferController {

    private final CreateOfferFacade facadeCreate;
    private final DisableOfferFacade facadeDelete;
    private final FindOfferFacade facadeFind;
    private final ListOfferByFarmerFacade facadeListByFarmer;
    private final ListOffersFacade facadeList;
    private final ExceptionHandlingAspect exceptionHandlingAspect;
    private static final Logger logger = LoggerFactory.getLogger(OfferController.class);


    public OfferController(CreateOfferFacade facade, DisableOfferFacade facadeDelete, FindOfferFacade facadeFind, ListOfferByFarmerFacade facadeListByFarmer, ListOffersFacade facadeList, ExceptionHandlingAspect exceptionHandlingAspect) {
        this.facadeCreate = facade;
        this.facadeDelete = facadeDelete;
        this.facadeFind = facadeFind;
        this.facadeListByFarmer = facadeListByFarmer;
        this.facadeList = facadeList;
        this.exceptionHandlingAspect = exceptionHandlingAspect;
    }

    @PostMapping("/offers")
    public ResponseEntity<Object> createOffer(@RequestBody OfferDTO input) {
        try {
            facadeCreate.execute(input);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return exceptionHandlingAspect.exceptionsInfrastructure(e);

        }
    }

    @DeleteMapping("/offers/{id}")
    public ResponseEntity<Object> disableOffer(@PathVariable(name = "id") int id) {
        try {
            LocalDateTime date = LocalDateTime.now();
            OfferDTO offer = new OfferDTO(id, 0, 0, "", 0, 0.0, date, date, true, "");
            facadeDelete.execute(offer);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return exceptionHandlingAspect.exceptionsInfrastructure(e);
        }
    }

    @GetMapping("/offers/{id}")
    public ResponseEntity<Object> findOffer(@PathVariable(name = "id") int id) {
        try {
            OfferDTO offer = new OfferDTO(id, 0, 0, "", 0, 0.0, LocalDateTime.now(), LocalDateTime.now(), true, "");
            OfferDTO result = facadeFind.execute(offer);
            logger.info("Oferta encontrada");
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return exceptionHandlingAspect.exceptionsInfrastructure(e);
        }
    }
    @GetMapping("/offers-farmers/{id}")
    public ResponseEntity<Object> listOffersByFarmer(@PathVariable(name = "id") int id) {
        try {
            OfferDTO offer = new OfferDTO(id, 0, id, "", 0, 0.0, LocalDateTime.now(), LocalDateTime.now(), true, "");
            List<OfferDTO> offerDTOS = facadeListByFarmer.execute(offer);
            return new ResponseEntity<>(offerDTOS, HttpStatus.OK);
        } catch (ExceptionHortalsoft e) {
            return exceptionHandlingAspect.exceptionsInfrastructure(e);
        }
    }

    @GetMapping("/offers")
    public ResponseEntity<Object> listOffers() {
        try {
            List<OfferDTO> offerDTOS = facadeList.execute();
            return new ResponseEntity<>(offerDTOS, HttpStatus.OK);
        } catch (ExceptionHortalsoft e) {
            return exceptionHandlingAspect.exceptionsInfrastructure(e);
        }
    }
}
