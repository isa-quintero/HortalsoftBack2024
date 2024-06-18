package com.hortalsoft.users.domain.port.input;

import java.util.List;

public interface UseCaseListDomainWithArg<D> {
    List<D> execute(D domain);
}
