package com.hortalsoft.products.application.mapper;

import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class MapperDomainToDto<D,T>{
    private static final ModelMapper mapper = new ModelMapper();
    public T mapToDto(D domain, Class<T> dto){
        return mapper.map(domain,dto);
    }
    public List<T> mapToDtoList(List<D> domainList, Class<T> dto){
        List<T> dtoList = new ArrayList<T>();
        domainList.forEach(domain -> dtoList.add(mapToDto(domain, dto)));
        return dtoList;
    }

}
