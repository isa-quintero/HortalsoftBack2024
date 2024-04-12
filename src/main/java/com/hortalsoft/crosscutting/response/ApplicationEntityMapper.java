package com.hortalsoft.crosscutting.response;

import java.util.List;

public interface ApplicationEntityMapper<Entity, Domain> {
    Entity toEntity(Domain domain);

    Domain toDomain(Entity entity);

    List<Domain> toDomains(List<Entity> entityList);

    List<Entity> toEntities(List<Domain> domainList);
}
