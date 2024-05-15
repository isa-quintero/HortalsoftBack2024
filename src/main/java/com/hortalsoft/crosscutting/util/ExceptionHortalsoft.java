package com.hortalsoft.crosscutting.util;

import lombok.Getter;


@Getter
public class ExceptionHortalsoft extends RuntimeException {
    private final int errorCode;
    private final Layer layer;

    public ExceptionHortalsoft(String message, int errorCode, Layer layer) {
        super(message);
        this.errorCode = errorCode;
        this.layer = layer;
    }
    public ExceptionHortalsoft(String message, int errorCode, Layer layer, Throwable cause) {
        super(message);
        this.errorCode = errorCode;
        this.layer = layer;
        this.setStackTrace(cause.getStackTrace());
    }
}

