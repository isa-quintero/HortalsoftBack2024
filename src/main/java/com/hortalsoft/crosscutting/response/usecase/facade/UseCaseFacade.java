package com.hortalsoft.crosscutting.response.usecase.facade;

public interface UseCaseFacade<T> {
    T execute(T dto);
}

