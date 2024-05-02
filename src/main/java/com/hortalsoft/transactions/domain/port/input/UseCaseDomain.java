package com.hortalsoft.transactions.domain.port.input;

public interface UseCaseDomain<D> {
    void execute(D domain);
}

