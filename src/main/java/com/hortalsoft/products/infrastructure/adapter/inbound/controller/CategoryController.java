package com.hortalsoft.products.infrastructure.adapter.inbound.controller;

import com.hortalsoft.products.application.dto.CategoryDTO;
import com.hortalsoft.products.application.facades.facade.category.FindCategoryFacade;
import com.hortalsoft.products.application.facades.facade.category.ListCategoryFacade;
import com.hortalsoft.products.util.ExceptionHandlingAspect;
import com.hortalsoft.products.util.ExceptionHortalsoft;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/category")
public class CategoryController {

    private final FindCategoryFacade facadeFind;
    private final ListCategoryFacade facadeList;
    private final ExceptionHandlingAspect exceptionHandlingAspect;
    private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);

    public CategoryController( FindCategoryFacade facadeFind, ListCategoryFacade facadeList, ExceptionHandlingAspect exceptionHandlingAspect) {
        this.facadeFind = facadeFind;
        this.facadeList = facadeList;
        this.exceptionHandlingAspect = exceptionHandlingAspect;
    }

    @GetMapping
    public ResponseEntity<?> findCategory(@RequestParam (name = "id") int id){
        try {
            CategoryDTO category = new CategoryDTO(id, "","");
            CategoryDTO categoryDTO = facadeFind.execute(category);
            logger.info("Categoria encontrada");
            return ResponseEntity.ok().body(categoryDTO);
        }
        catch (ExceptionHortalsoft e){
            return exceptionHandlingAspect.exceptionsInfrastructure(e);
        }

    }

    @GetMapping("/list")
    public ResponseEntity<?> listCategories(){
        try{
            List<CategoryDTO> categoryDTOs = facadeList.execute();
            return new ResponseEntity<>(categoryDTOs, HttpStatus.OK);
        }
        catch (ExceptionHortalsoft e){
            return exceptionHandlingAspect.exceptionsInfrastructure(e);
        }
    }
}
