package com.hortalsoft.transactions.domain.mapper;

import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class MapperEntityToDomain<E,D> {
    private static final ModelMapper mapper = new ModelMapper();

    public D mapToDomain(E entity, Class<D> domain){
        return mapper.map(entity, domain);
    }
    public List<D> mapToDomainList(List<E> entityList, Class<D> domain){
        List<D> domainList = new ArrayList<D>();
        entityList.forEach(dto -> domainList.add(mapToDomain(dto, domain)));
        return domainList;
    }
}
