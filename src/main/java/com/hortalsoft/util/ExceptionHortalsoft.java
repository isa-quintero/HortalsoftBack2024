package com.hortalsoft.util;

import lombok.Getter;


@Getter
public class ExceptionHortalsoft extends RuntimeException {
    private final int errorCode;
    private final Layers layer;

    public ExceptionHortalsoft(String message, int errorCode, Layers layer) {
        super(message);
        this.errorCode = errorCode;
        this.layer = layer;
    }
    public ExceptionHortalsoft(String message, int errorCode, Layers layer, Throwable cause) {
        super(message);
        this.errorCode = errorCode;
        this.layer = layer;
    }
}

