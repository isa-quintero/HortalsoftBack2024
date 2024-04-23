package com.hortalsoft.products.util.usecase.facade;

public interface UseCaseFindFacade<T>{
    T execute(T dto);
}
