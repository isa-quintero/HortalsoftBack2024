package com.hortalsoft.crosscutting.response.usecase.domain;

public interface UseCaseFindDomain<D>{
    D execute(D domain);
}
