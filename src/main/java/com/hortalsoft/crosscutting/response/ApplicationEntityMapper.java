package com.hortalsoft.crosscutting.response;

import java.util.List;

public interface ApplicationEntityMapper<E, D> {
    E toEntity(D domain);

    D toDomain(E entity);


    List<D> toDomains(List<E> entityList);

    List<E> toEntities(List<D> domainList);
}
