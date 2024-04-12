package com.hortalsoft.crosscutting.response.usecase.domain;

import java.util.List;
import java.util.Optional;

public interface UseCaseListDomain<D> {
    List<D> execute(Optional<D> domain);
}
