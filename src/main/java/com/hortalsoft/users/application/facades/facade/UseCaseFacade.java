package com.hortalsoft.users.application.facades.facade;

public interface UseCaseFacade<T> {
    void execute(T dto);
}

