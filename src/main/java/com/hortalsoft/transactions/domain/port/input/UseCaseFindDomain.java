package com.hortalsoft.transactions.domain.port.input;

public interface UseCaseFindDomain<D>{
    D execute(D domain);
}
