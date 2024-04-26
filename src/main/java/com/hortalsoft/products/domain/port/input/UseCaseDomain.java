package com.hortalsoft.products.domain.port.input;

public interface UseCaseDomain<D> {
    void execute(D domain);
}

