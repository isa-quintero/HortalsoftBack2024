package com.hortalsoft.products.util.usecase.domain;

public interface UseCaseFindDomain<D>{
    D execute(D domain);
}
