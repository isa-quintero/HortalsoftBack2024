package com.hortalsoft.products.domain.port;

public interface UseCaseDomain<D> {
    void execute(D domain);
}

