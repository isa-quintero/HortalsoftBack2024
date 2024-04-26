package com.hortalsoft.products.infrastructure.adapter.inbound.controller;

import com.hortalsoft.products.application.dto.OfferDTO;
import com.hortalsoft.products.application.facades.facade.offer.CreateOfferFacade;
import com.hortalsoft.products.application.facades.facade.offer.DisableOfferFacade;
import com.hortalsoft.products.application.facades.facade.offer.FindOfferFacade;
import com.hortalsoft.products.application.facades.facade.offer.ListOfferFacade;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


@RestController
@RequestMapping("/offers")
public class OfferController {

    private final CreateOfferFacade facadeCreate;
    private final DisableOfferFacade facadeDelete;
    private final FindOfferFacade facadeFind;
    private final ListOfferFacade facadeList;

    public OfferController(CreateOfferFacade facade, DisableOfferFacade facadeDelete, FindOfferFacade facadeFind, ListOfferFacade facadeList) {
        this.facadeCreate = facade;
        this.facadeDelete = facadeDelete;
        this.facadeFind = facadeFind;
        this.facadeList = facadeList;
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
    public ResponseEntity<OfferDTO> disableOffer(@RequestParam (name = "id") long id){
        try{
            OfferDTO offer = new OfferDTO();
            offer.setId(id);
            offer.setDescription("");
            offer.setPrice(0);
            offer.setAmount(0);
            offer.setValidity(0);
            offer.setFinalDate(new Date());
            offer.setInitialDate(new Date());
            facadeDelete.execute(offer);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Error e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @GetMapping
    public ResponseEntity<OfferDTO> findOffer(@RequestParam (name = "id") long id){
        try{
            OfferDTO offer = new OfferDTO();
            offer.setId(id);
            offer.setDescription("");
            offer.setPrice(0);
            offer.setAmount(0);
            offer.setValidity(0);
            offer.setFinalDate(new Date());
            offer.setInitialDate(new Date());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Error e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @GetMapping("/list")
    public ResponseEntity<OfferDTO> listOffers(){
        return null;
    }
}