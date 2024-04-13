package com.hortalsoft.products.util.mapper;

import org.modelmapper.ModelMapper;

public class MapperDTOToDomain<T,D>{
    private static final ModelMapper mapper = new ModelMapper();
    public D mapToDomain(T dto, Class<D> domain){
        return mapper.map(dto, domain);
    }

}
