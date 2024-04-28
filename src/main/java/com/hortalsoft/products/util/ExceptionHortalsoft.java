package com.hortalsoft.products.util;

import lombok.Getter;

@Getter
public class ExceptionHortalsoft extends RuntimeException {
    private final int errorCode;
    private final String layer;

    public ExceptionHortalsoft(String message, int errorCode, String layer) {
        super(message);
        this.errorCode = errorCode;
        this.layer=layer;
    }
}

