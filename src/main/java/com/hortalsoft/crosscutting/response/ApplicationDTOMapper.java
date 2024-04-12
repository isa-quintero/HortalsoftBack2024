package com.hortalsoft.crosscutting.response;

import java.util.List;

public interface ApplicationDTOMapper<DTO, DOM> {
    DOM toDomain(DTO dto);

    DTO toDto(DOM dom);

    List<DOM> toDomains(List<DTO> dtoList);

    List<DTO> toDtos(List<DOM> domList);
}
