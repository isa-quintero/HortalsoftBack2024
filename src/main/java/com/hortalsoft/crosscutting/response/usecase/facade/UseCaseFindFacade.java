package com.hortalsoft.crosscutting.response.usecase.facade;

public interface UseCaseFindFacade<T,D>{
    D execute(T dto);
}
