package com.hortalsoft.products.util.mapper;

import org.modelmapper.ModelMapper;

import java.util.Collections;
import java.util.List;

public class MapperDTOToDomain<T,D>{
    private static final ModelMapper mapper = new ModelMapper();
    public D mapToDomain(T dto, Class<D> domain){
        return mapper.map(dto, domain);
    }
    public List<D> mapToDomainList(List<T> dtoList, Class<D> domain){
        return Collections.singletonList(mapper.map(dtoList, domain));
    }

}
