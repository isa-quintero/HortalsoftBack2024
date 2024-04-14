package com.hortalsoft.products.util.usecase.facade;

public interface UseCaseFacade<T> {
    void execute(T dto);
}

