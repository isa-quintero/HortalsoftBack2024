package com.hortalsoft.products.util.mapper;

import org.modelmapper.ModelMapper;

public class MapperDtoToEntity<T,E>{
    private static final ModelMapper mapper = new ModelMapper();
    public E mapToEntity(T dto, Class<E> entity){
        return mapper.map(dto,entity);
    }

}
