package com.hortalsoft.products.util.usecase.facade;

public interface UseCaseFacade<T> {
    T execute(T dto);
}

