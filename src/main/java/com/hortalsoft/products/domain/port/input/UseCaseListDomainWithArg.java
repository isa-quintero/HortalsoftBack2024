package com.hortalsoft.products.domain.port.input;

import java.util.List;

public interface UseCaseListDomainWithArg<D> {
    List<D> execute(D domain);
}
