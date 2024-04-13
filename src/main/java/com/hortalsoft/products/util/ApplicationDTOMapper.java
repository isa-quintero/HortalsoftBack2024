package com.hortalsoft.products.util;

import java.util.List;

public interface ApplicationDTOMapper<T, D> {
    D toDomain(T dto);

    T toDto(D dom);

    List<D> toDomains(List<T> dtoList);

    List<T> toDtos(List<D> domList);
}
