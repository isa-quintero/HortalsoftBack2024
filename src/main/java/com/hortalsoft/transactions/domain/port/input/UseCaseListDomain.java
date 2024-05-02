package com.hortalsoft.transactions.domain.port.input;

import java.util.List;

public interface UseCaseListDomain<D> {
    List<D> execute();
}
