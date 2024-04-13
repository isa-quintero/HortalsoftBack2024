package com.hortalsoft.products.util.usecase.domain;

public interface UseCaseFindDomain<D,E>{
    E execute(D domain);
}
