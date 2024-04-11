package com.hortalsoft.products.domain.port;

import java.util.List;
import java.util.Optional;

public interface ServiceListDomain<D> {
    List<D> execute(Optional<D> domain);
}
