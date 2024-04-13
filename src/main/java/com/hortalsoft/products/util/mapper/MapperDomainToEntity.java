package com.hortalsoft.products.util.mapper;

import org.modelmapper.ModelMapper;

public class MapperDomainToEntity<D,E> {
    private static final ModelMapper mapper = new ModelMapper();

    public E mapToEntity(D domain, Class<E> entity){
        return mapper.map(domain,entity);
    }
}
