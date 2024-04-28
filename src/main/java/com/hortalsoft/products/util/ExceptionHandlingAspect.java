package com.hortalsoft.products.util;

import org.aspectj.lang.annotation.*;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Aspect
public class ExceptionHandlingAspect {
    @AfterThrowing(pointcut = "execution(* com.hortalsoft.products.*.*(..))", throwing = "ex")
    public ResponseEntity<String> handleException(Exception ex) {
        HttpStatus status = HttpStatus.OK;
        if (ex instanceof ExceptionHortalsoft exceptionHortalsoft) {
            status = switch (exceptionHortalsoft.getErrorCode()) {
                case 4001 -> HttpStatus.BAD_REQUEST;
                case 5001 -> HttpStatus.FORBIDDEN;
                case 6001 -> HttpStatus.NOT_FOUND;
                default -> status;
            };
        }
        return ResponseEntity.status(status).body(ex.getMessage());
    }
}
