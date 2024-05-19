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
    private static final Layer layerApp = Layer.APPLICATION;
    private static final Layer layerInfra = Layer.INFRASTRUCTURE;

    @AfterThrowing(pointcut = "execution(* com.hortalsoft.products.*.*(..))", throwing = "exception")
    public ResponseEntity<String> handleException(Exception exception) {
        logger.error("Exception occurred: {}", exception.getMessage());
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        if (exception instanceof ExceptionHortalsoft exceptionHortalsoft) {
            status = switch (exceptionHortalsoft.getErrorCode()) {
                case 4001 -> HttpStatus.BAD_REQUEST;
                case 5001 -> HttpStatus.FORBIDDEN;
                case 6001 -> HttpStatus.NOT_FOUND;
                default -> HttpStatus.INTERNAL_SERVER_ERROR;
            };
        }
        return ResponseEntity.status(status).body(exception.getMessage());
    }

    public ResponseEntity<String> exceptionsInfrastructure(Exception exception){
        String message;
        Layer layer;
        if (exception instanceof ExceptionHortalsoft){
            message = exception.getMessage();
            layer = ((ExceptionHortalsoft) exception).getLayer();
        }else{
            message = "Ha ocurrido un error inesperado";
            layer = layerInfra;
            exception = new ExceptionHortalsoft(message,500, layerInfra,exception);
        }
        logException(message,layer);
        return createResponse(exception);
    }

    private void logException(String message, Layer layer){
        logger.error("{}: Capa {}", message, layer);
    }

    private ResponseEntity<String> createResponse(Exception exception){
        return handleException(exception);
    }

    public void exceptionsApplication(Exception exception){
        if (exception instanceof ExceptionHortalsoft){
            throw (ExceptionHortalsoft) exception;
        }else{
            throw new ExceptionHortalsoft("Ha ocurrido un error inesperado",500, layerApp,exception);
        }
    }
}
