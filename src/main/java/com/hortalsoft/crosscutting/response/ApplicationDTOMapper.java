package com.hortalsoft.crosscutting.response;

import java.util.List;

public interface ApplicationDTOMapper<Dto, Domain> {
    Domain toDomain(Dto dto);

    Dto toDto(Domain domain);

    List<Domain> toDomains(List<Dto> dtoList);

    List<Dto> toDtos(List<Domain> domainList);
}