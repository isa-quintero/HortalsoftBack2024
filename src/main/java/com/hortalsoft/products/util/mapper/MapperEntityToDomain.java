package com.hortalsoft.products.util.mapper;

import org.modelmapper.ModelMapper;

public class MapperEntityToDomain<E,D> {
    private static final ModelMapper mapper = new ModelMapper();

    public D mapToDomain(E entity, Class<D> domain){
        return mapper.map(entity, domain);
    }
}
