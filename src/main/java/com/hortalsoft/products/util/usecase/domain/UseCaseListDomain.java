package com.hortalsoft.products.util.usecase.domain;

import java.util.List;
import java.util.Optional;

public interface UseCaseListDomain<D> {
    List<D> execute();
}
