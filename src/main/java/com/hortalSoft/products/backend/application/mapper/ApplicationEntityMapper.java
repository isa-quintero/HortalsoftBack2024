package com.hortalSoft.products.backend.application.mapper;

import java.util.List;

public interface ApplicationEntityMapper<Dto, Domain> {
    Domain toDomain(Dto dto);

    Dto toDto(Domain domain);

    List<Domain> toDomains(List<Dto> dtoList);

    List<Dto> toDtos(List<Domain> domainList);
}
