package com.hortalsoft.products.domain.port;

import java.util.List;

public interface UseCaseListDomain<D> {
    List<D> execute();
}
