package com.hortalsoft.users.infrastructure.adapter.inbound.controller;


import com.hortalsoft.users.application.facades.facade.user.AuthenticateUserFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class AuthController {

    private final AuthenticateUserFacade authenticateUserFacade;

    @Autowired
    public AuthController(AuthenticateUserFacade authenticateUserFacade) {
        this.authenticateUserFacade = authenticateUserFacade;
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody Map<String, String> payload) {
        String idToken = payload.get("idToken");
        Map<String, String> response = authenticateUserFacade.execute(idToken);

        if (response.containsKey("message")) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }
}
