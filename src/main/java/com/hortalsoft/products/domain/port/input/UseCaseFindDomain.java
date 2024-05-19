package com.hortalsoft.products.domain.port.input;

public interface UseCaseFindDomain<D> {
    D execute(D domain);
}
