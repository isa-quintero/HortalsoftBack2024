package com.hortalsoft.users.application.mapper;

import com.hortalsoft.crosscutting.response.ApplicationEntityMapper;
import com.hortalsoft.users.application.dto.AssociationDTO;
import com.hortalsoft.users.domain.domain.Association;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface ApplicationAssociationMapper extends ApplicationEntityMapper<AssociationDTO, Association> {
}
