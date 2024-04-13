package com.hortalsoft.products.util.usecase.facade;

public interface UseCaseFindFacade<T,D>{
    D execute(T dto);
}
