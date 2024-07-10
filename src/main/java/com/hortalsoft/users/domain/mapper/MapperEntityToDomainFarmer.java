package com.hortalsoft.users.domain.mapper;

import com.hortalsoft.users.domain.domain.Farmer;
import com.hortalsoft.users.domain.entity.FarmerEntity;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MapperEntityToDomainFarmer {

    public Farmer mapToFarmer(FarmerEntity entity) {
        if (entity == null) {
            return null;
        }

        Farmer farmer = new Farmer();
        farmer.setIdUser(entity.getIdUser());
        farmer.setDocumentTypeId(entity.getDocumentType().getIdDocumentType());
        farmer.setNumberId(entity.getNumberId());
        farmer.setUsername(entity.getUsername());
        farmer.setPhoneNumber(entity.getPhoneNumber());
        farmer.setEmail(entity.getEmail());
        farmer.setAddress(entity.getAddress());
        farmer.setCity(entity.getCity());
        farmer.setUserType(entity.getUserType());

        // Map associationId
        if (entity.getAssociation() != null) {
            farmer.setAssociationId(entity.getAssociation().getIdUser());
        }

        return farmer;
    }

    public List<Farmer> mapToDomainList(List<FarmerEntity> entityList) {
        return entityList.stream()
                .map(this::mapToFarmer)
                .collect(Collectors.toList());
    }
}
