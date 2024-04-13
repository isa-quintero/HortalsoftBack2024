package com.hortalsoft.products.util.usecase.domain;

public interface UseCaseDomain<D> {
    void execute(D domain);
}

