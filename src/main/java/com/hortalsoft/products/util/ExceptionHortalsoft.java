package com.hortalsoft.products.util;

public class ExceptionHortalsoft extends RuntimeException {
    private final int errorCode;

    public ExceptionHortalsoft(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }
}

