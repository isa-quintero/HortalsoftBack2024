package com.hortalsoft.users.infrastructure.adapter.inbound.controller;

import com.hortalsoft.crosscutting.util.ExceptionHandlingAspect;
import com.hortalsoft.crosscutting.util.ExceptionHortalsoft;
import com.hortalsoft.products.infrastructure.adapter.inbound.controller.OfferController;
import com.hortalsoft.users.application.dto.UserDTO;
import com.hortalsoft.users.application.facades.facade.user.*;
import com.hortalsoft.users.util.UserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profiles")
public class AssociationController {

}
