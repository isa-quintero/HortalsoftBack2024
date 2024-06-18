package com.hortalsoft.users.application.mapper;

import org.modelmapper.ModelMapper;

import java.util.List;

public class MapperDTOToDomain<T, D> {
    private static final ModelMapper mapper = new ModelMapper();

    /**
     * Maps a DTO object to a domain object using the ModelMapper library.
     *
     * @param dto    The DTO object to be mapped.
     * @param domain The class of the domain object.
     * @return The mapped domain object.
     */
    public D mapToDomain(T dto, Class<D> domain) {
        return mapper.map(dto, domain);
    }

    /**
     * Maps a list of DTO objects to a list of domain objects using the ModelMapper library.
     *
     * @param dtoList The list of DTO objects to be mapped.
     * @param domain  The class of the domain object.
     * @return The list of mapped domain objects.
     */
    public List<D> mapToDomainList(List<T> dtoList, Class<D> domain) {
        return dtoList.parallelStream()
                .map(dto -> mapToDomain(dto, domain))
                .toList();
    }
}
