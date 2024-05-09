package com.hortalsoft.crosscutting.util;

import org.aspectj.lang.annotation.*;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@Aspect
public class ExceptionHandlingAspect {
    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandlingAspect.class);

    @AfterThrowing(pointcut = "execution(* com.hortalsoft.products.*.*(..))", throwing = "ex")
    public ResponseEntity<String> handleException(Exception ex) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
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

    public ResponseEntity<String> exceptionsInfrastructure(Exception e){
        String message;
        String layer;
        if (e instanceof ExceptionHortalsoft){
            message=e.getMessage();
            layer= String.valueOf(((ExceptionHortalsoft) e).getLayer());
        }else{
            ExceptionHortalsoft ex = new ExceptionHortalsoft(e.getMessage(),500,Layers.INFRASTRUCTURE);
            message= ex.getMessage();
            layer= String.valueOf(ex.getLayer());
        }
        logger.error("{}: Capa {}",message,layer);
        return handleException(e);
    }

    public void exceptionsApplication(Exception e){
        if (e instanceof ExceptionHortalsoft){
            throw (ExceptionHortalsoft) e;
        }else{
            throw new ExceptionHortalsoft(e.getMessage(),500,Layers.APPLICATION);
        }
    }
}
