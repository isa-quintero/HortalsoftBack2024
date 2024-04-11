package com.hortalsoft.products.domain.port;

public interface ServiceDomain<D> {
    void execute(D domain);
}

