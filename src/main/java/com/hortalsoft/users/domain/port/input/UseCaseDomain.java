package com.hortalsoft.users.domain.port.input;

public interface UseCaseDomain<D> {
    void execute(D domain);
}

