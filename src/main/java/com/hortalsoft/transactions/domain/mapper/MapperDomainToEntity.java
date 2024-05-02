package com.hortalsoft.transactions.domain.mapper;

import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class MapperDomainToEntity<D,E> {
    private static final ModelMapper mapper = new ModelMapper();

    public E mapToEntity(D domain, Class<E> entity){
        return mapper.map(domain,entity);
    }
    public List<E> mapToEntityList(List<D> domainList, Class<E> entity){
        List<E> entityList = new ArrayList<E>();
        domainList.forEach(dto -> entityList.add(mapToEntity(dto, entity)));
        return entityList;
    }
}
