package com.hortalsoft.products.application.facades.facade;

public interface UseCaseFacade<T> {
    void execute(T dto);
}

