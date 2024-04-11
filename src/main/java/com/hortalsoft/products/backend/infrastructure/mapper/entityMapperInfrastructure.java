package com.hortalsoft.products.backend.infrastructure.mapper;

import java.util.List;

public interface entityMapperInfrastructure<Entity, Domain>{
    Entity toEntity(Domain domain);

    Domain toDomain(Entity entity);

    List<Domain> toDomains(List<Entity> entityList);

    List<Entity> toEntities(List<Domain> domainList);

}
