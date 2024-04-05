package com.hortalSoft.products.backend.infraestructure.mapper;

import java.util.List;

public interface InfraestructuraEntityMapper<Entity, Domain>{
    Entity toEntity(Domain domain);

    Domain toDomain(Entity entity);

    List<Domain> toDomains(List<Entity> entityList);

    List<Entity> toEntities(List<Domain> domainList);

}
