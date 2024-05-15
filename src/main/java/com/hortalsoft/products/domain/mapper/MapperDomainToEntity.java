package com.hortalsoft.products.domain.mapper;

import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class MapperDomainToEntity<D,E> {
    private static final ModelMapper mapper = new ModelMapper();

    /**
     * Maps a domain object to an entity object.
     *
     * @param domain the domain object to be mapped
     * @param entity the class of the entity object
     * @return the mapped entity object
     */
    public E mapToEntity(D domain, Class<E> entity){
        return mapper.map(domain,entity);
    }

    /**
     * Maps a list of domain objects to a list of entity objects.
     *
     * @param domainList the list of domain objects to be mapped
     * @param entity the class of the entity object
     * @return the list of mapped entity objects
     */
    public List<E> mapToEntityList(List<D> domainList, Class<E> entity){
        List<E> entityList = new ArrayList<E>();
        domainList.forEach(dto -> entityList.add(mapToEntity(dto, entity)));
        return entityList;
    }
}
