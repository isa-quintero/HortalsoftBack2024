package com.hortalsoft.transactions.application.mapper;

import org.modelmapper.ModelMapper;
import java.util.ArrayList;
import java.util.List;

public class MapperDTOToDomain<T,D>{
    private static final ModelMapper mapper = new ModelMapper();
    public D mapToDomain(T dto, Class<D> domain){
        return mapper.map(dto, domain);
    }
    public List<D> mapToDomainList(List<T> dtoList, Class<D> domain){
        List<D> domainList = new ArrayList<D>();
        dtoList.forEach(dto -> domainList.add(mapToDomain(dto, domain)));
        return domainList;
    }

}
