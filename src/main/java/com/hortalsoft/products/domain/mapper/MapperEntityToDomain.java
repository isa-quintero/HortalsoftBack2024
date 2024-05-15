package com.hortalsoft.products.domain.mapper;

import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class MapperEntityToDomain<E,D> {
    private static final ModelMapper mapper = new ModelMapper();

    /**
     * Maps an entity object to a domain object using the ModelMapper library.
     *
     * @param entity the entity object to be mapped
     * @param domain the class of the domain object
     * @return the mapped domain object
     */
    public D mapToDomain(E entity, Class<D> domain){
        return mapper.map(entity, domain);
    }

    /**
     * Maps a list of entity objects to a list of domain objects using the ModelMapper library.
     *
     * @param entityList the list of entity objects to be mapped
     * @param domain the class of the domain object
     * @return the list of mapped domain objects
     */
    public List<D> mapToDomainList(List<E> entityList, Class<D> domain){
        List<D> domainList = new ArrayList<>();
        entityList.forEach(dto -> domainList.add(mapToDomain(dto, domain)));
        return domainList;
    }
}
