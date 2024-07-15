package com.hortalsoft.products.infrastructure.adapter.inbound.controller;

import com.hortalsoft.products.application.dto.SubcategoryDTO;
import com.hortalsoft.products.application.facades.facade.subcategory.FindSubcategoryFacade;
import com.hortalsoft.products.application.facades.facade.subcategory.ListSubcategoryFacade;
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

    @Operation(summary = "Encuentra una subcategoria por su id", description = "Regresa una subcategoria por un id dado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Subcategoria encontrada",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = SubcategoryDTO.class))),
            @ApiResponse(responseCode = "404", description = "Subcategoria no encontrada",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Error inesperado",
                    content = @Content)
    })
    @GetMapping("/subcategories/{id}")
    public ResponseEntity<Object> findSubcategory(@PathVariable(name = "id") int id) {
        try {
            SubcategoryDTO subcategory = new SubcategoryDTO(id, "", "", 0);
            SubcategoryDTO subcategoryDTO = facadeFind.execute(subcategory);
            logger.info("Subcategoria encontrada");
            return ResponseEntity.ok().body(subcategoryDTO);
        } catch (ExceptionHortalsoft e) {
            return exceptionHandlingAspect.exceptionsInfrastructure(e);
        }
    }

    @Operation(summary = "Lista todas las subcategorias", description = "Regresa una lista con todas las subcategorias")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Subcategorias listadas",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = SubcategoryDTO.class))),
            @ApiResponse(responseCode = "404", description = "No hay subcategorias para listar",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Error inesperado ",
                    content = @Content)
    })
    @GetMapping("/subcategories")
    public ResponseEntity<Object> listSubcategories() {
        try {
            List<SubcategoryDTO> subcategoryDTOS = facadeList.execute();
            return new ResponseEntity<>(subcategoryDTOS, HttpStatus.OK);
        } catch (ExceptionHortalsoft e) {
            return exceptionHandlingAspect.exceptionsInfrastructure(e);
        }
    }
}
