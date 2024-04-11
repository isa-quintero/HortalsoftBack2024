package com.hortalsoft.transactions.backend.application.mapper;

import java.util.List;

public interface AplicacionEntityMapper<Dto, Domain> {
    Domain toDomain(Dto dto);

    Dto toDto(Domain domain);

    List<Domain> toDomains(List<Dto> dtoList);

    List<Dto> toDtos(List<Domain> domainList);
}
