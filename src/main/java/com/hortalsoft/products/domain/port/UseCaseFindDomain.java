package com.hortalsoft.products.domain.port;

public interface UseCaseFindDomain<D>{
    D execute(D domain);
}
