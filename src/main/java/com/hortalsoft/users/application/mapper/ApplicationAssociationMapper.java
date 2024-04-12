package com.hortalsoft.users.application.mapper;

import com.hortalsoft.crosscutting.response.ApplicationDTOMapper;
import com.hortalsoft.users.application.dto.AssociationDTO;
import com.hortalsoft.users.domain.domain.Association;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface ApplicationAssociationMapper extends ApplicationDTOMapper<AssociationDTO, Association> {
}
