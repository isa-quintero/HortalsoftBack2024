package com.hortalsoft.products.infrastructure.adapter.inbound.controller;

import com.hortalsoft.products.application.dto.CategoryDTO;
import com.hortalsoft.products.application.dto.SubcategoryDTO;
import com.hortalsoft.products.application.facades.facade.category.FindCategoryFacade;
import com.hortalsoft.products.application.facades.facade.category.ListCategoryFacade;
import com.hortalsoft.crosscutting.util.ExceptionHandlingAspect;
import com.hortalsoft.crosscutting.util.ExceptionHortalsoft;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/inventory")
public class CategoryController {

    private final FindCategoryFacade facadeFind;
    private final ListCategoryFacade facadeList;
    private final ExceptionHandlingAspect exceptionHandlingAspect;
    private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);

    public CategoryController(FindCategoryFacade facadeFind, ListCategoryFacade facadeList, ExceptionHandlingAspect exceptionHandlingAspect) {
        this.facadeFind = facadeFind;
        this.facadeList = facadeList;
        this.exceptionHandlingAspect = exceptionHandlingAspect;
    }

    @Operation(summary = "Encuentra una categoria por su id", description = "Regresa una categoria por un id dado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Categoria encontrada",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = SubcategoryDTO.class))),
            @ApiResponse(responseCode = "404", description = "Categoria no encontrada",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Error inesperado",
                    content = @Content)
    })
    @GetMapping("/categories/{id}")
    public ResponseEntity<Object> findCategory(@PathVariable(name = "id") int id) {
        try {
            CategoryDTO category = new CategoryDTO(id, "", "");
            CategoryDTO categoryDTO = facadeFind.execute(category);
            logger.info("Categoria encontrada");
            return ResponseEntity.ok().body(categoryDTO);
        } catch (ExceptionHortalsoft e) {
            return exceptionHandlingAspect.exceptionsInfrastructure(e);
        }

    }

    @Operation(summary = "Lista todas las categorias", description = "Regresa una lista con todas las categorias")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Categorias listadas",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = SubcategoryDTO.class))),
            @ApiResponse(responseCode = "404", description = "No hay categorias para listar",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Error inesperado ",
                    content = @Content)
    })
    @GetMapping("/categories")
    public ResponseEntity<Object> listCategories() {
        try {
            List<CategoryDTO> categoryDTOs = facadeList.execute();
            return new ResponseEntity<>(categoryDTOs, HttpStatus.OK);
        } catch (ExceptionHortalsoft e) {
            return exceptionHandlingAspect.exceptionsInfrastructure(e);
        }
    }
}
