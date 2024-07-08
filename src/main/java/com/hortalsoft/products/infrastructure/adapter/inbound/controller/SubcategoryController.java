package com.hortalsoft.products.infrastructure.adapter.inbound.controller;

import com.hortalsoft.products.application.dto.SubcategoryDTO;
import com.hortalsoft.products.application.facades.facade.subcategory.FindSubcategoryFacade;
import com.hortalsoft.products.application.facades.facade.subcategory.ListSubcategoryFacade;
import com.hortalsoft.crosscutting.util.ExceptionHandlingAspect;
import com.hortalsoft.crosscutting.util.ExceptionHortalsoft;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/inventory")
public class SubcategoryController {

    private final FindSubcategoryFacade facadeFind;
    private final ListSubcategoryFacade facadeList;
    private final ExceptionHandlingAspect exceptionHandlingAspect;
    private static final Logger logger = LoggerFactory.getLogger(SubcategoryController.class);

    public SubcategoryController(FindSubcategoryFacade facadeFind, ListSubcategoryFacade facadeList, ExceptionHandlingAspect exceptionHandlingAspect) {
        this.facadeFind = facadeFind;
        this.facadeList = facadeList;
        this.exceptionHandlingAspect = exceptionHandlingAspect;
    }

    @GetMapping("/subcategories/{id}")
    public ResponseEntity<Object> findSubcategory(@PathVariable (name = "id") int id){
        try {
            SubcategoryDTO subcategory = new SubcategoryDTO(id, "","",0);
            SubcategoryDTO subcategoryDTO = facadeFind.execute(subcategory);
            logger.info("Subcategoria encontrado");
            return ResponseEntity.ok().body(subcategoryDTO);
        }
        catch (ExceptionHortalsoft e){
            return exceptionHandlingAspect.exceptionsInfrastructure(e);
        }
    }

    @GetMapping("/subcategories")
    public ResponseEntity<Object> listSubcategories(){
        try{
            List<SubcategoryDTO> subcategoryDTOS = facadeList.execute();
            return new ResponseEntity<>(subcategoryDTOS, HttpStatus.OK);
        }
        catch (ExceptionHortalsoft e){
            return exceptionHandlingAspect.exceptionsInfrastructure(e);
        }
    }
}
