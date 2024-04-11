package com.hortalsoft.transactions.backend.infraestructure.mapper;

import java.util.List;

public interface EntityMapperInfrastructure<Entity, Domain>{
    Entity toEntity(Domain domain);

    Domain toDomain(Entity entity);

    List<Domain> toDomains(List<Entity> entityList);

    List<Entity> toEntities(List<Domain> domainList);

}
