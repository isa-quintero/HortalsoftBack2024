package com.hortalsoft.crosscutting.response.usecase.domain;

public interface UseCaseFindDomain<D,E>{
    E execute(D domain);
}
