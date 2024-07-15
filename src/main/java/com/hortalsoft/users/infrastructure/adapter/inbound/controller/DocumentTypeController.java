package com.hortalsoft.users.infrastructure.adapter.inbound.controller;

import com.hortalsoft.crosscutting.util.ExceptionHandlingAspect;
import com.hortalsoft.crosscutting.util.ExceptionHortalsoft;
import com.hortalsoft.users.application.dto.DocumentTypeDTO;
import com.hortalsoft.users.application.facades.facade.documenttype.FindDocumentTypeFacade;
import com.hortalsoft.users.application.facades.facade.documenttype.ListDocumentTypeFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/profiles")
public class    DocumentTypeController {

    private final FindDocumentTypeFacade facadeFind;
    private final ListDocumentTypeFacade facadeList;
    private final ExceptionHandlingAspect exceptionHandlingAspect;
    private static final Logger logger = LoggerFactory.getLogger(DocumentTypeController.class);

    public DocumentTypeController(FindDocumentTypeFacade facadeFind, ListDocumentTypeFacade facadeList, ExceptionHandlingAspect exceptionHandlingAspect) {
        this.facadeFind = facadeFind;
        this.facadeList = facadeList;
        this.exceptionHandlingAspect = exceptionHandlingAspect;
    }

    @GetMapping("/document-types/{id}")
    public ResponseEntity<Object> findCategory(@PathVariable(name = "id") int id) {
        try {
            DocumentTypeDTO documentType = new DocumentTypeDTO(id, "", "","");
            DocumentTypeDTO documentTypeDTO = facadeFind.execute(documentType);
            logger.info("Tipo de documento encontrada");
            return ResponseEntity.ok().body(documentTypeDTO);
        } catch (ExceptionHortalsoft e) {
            return exceptionHandlingAspect.exceptionsInfrastructure(e);
        }

    }

    @GetMapping("/document-types")
    public ResponseEntity<Object> listCategories() {
        try {
            List<DocumentTypeDTO> documentTypeDTOS = facadeList.execute();
            return new ResponseEntity<>(documentTypeDTOS, HttpStatus.OK);
        } catch (ExceptionHortalsoft e) {
            return exceptionHandlingAspect.exceptionsInfrastructure(e);
        }
    }
}
