package com.hortalsoft.crosscutting.response.usecase.domain;

public interface UseCaseDomain<D> {
    void execute(D domain);
}

