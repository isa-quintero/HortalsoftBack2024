package com.hortalsoft.transactions.application.facades.facade;

public interface UseCaseFindFacade<T>{
    T execute(T dto);
}
