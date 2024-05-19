package com.hortalsoft.products.application.mapper;

import org.modelmapper.ModelMapper;

import java.util.List;

public class MapperDomainToDto<D, T> {
    private final ModelMapper mapper;

    public MapperDomainToDto() {
        this.mapper = new ModelMapper();
    }

    /**
     * Maps a domain object to a DTO object using the ModelMapper library.
     *
     * @param domain the domain object to be mapped
     * @param dto    the class of the DTO object
     * @return the mapped DTO object
     */
    public T mapToDto(D domain, Class<T> dto) {
        return mapper.map(domain, dto);
    }

    /**
     * Maps a list of domain objects to a list of DTO objects using the ModelMapper library.
     *
     * @param domainList the list of domain objects to be mapped
     * @param dto        the class of the DTO object
     * @return the list of mapped DTO objects
     */
    public List<T> mapToDtoList(List<D> domainList, Class<T> dto) {
        return domainList.parallelStream()
                .map(domain -> mapToDto(domain, dto))
                .toList();
    }
}
