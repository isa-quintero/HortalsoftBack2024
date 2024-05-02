package com.hortalsoft.transactions.application.facades.facade;

public interface UseCaseFacade<T> {
    void execute(T dto);
}

