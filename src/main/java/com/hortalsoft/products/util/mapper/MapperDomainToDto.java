package com.hortalsoft.products.util.mapper;

import org.modelmapper.ModelMapper;

public class MapperDomainToDto<D,T>{
    private static final ModelMapper mapper = new ModelMapper();
    public T mapToDto(D domain, Class<T> dto){
        return mapper.map(domain,dto);
    }

}
