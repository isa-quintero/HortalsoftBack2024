package com.hortalsoft.crosscutting.response;

import java.util.List;

public interface ApplicationEntityMapper<ENT, DOM> {
    ENT toEntity(DOM domain);

    DOM toDomain(ENT entity);

    List<DOM> toDomains(List<ENT> entityList);

    List<ENT> toEntities(List<DOM> domainList);
}
