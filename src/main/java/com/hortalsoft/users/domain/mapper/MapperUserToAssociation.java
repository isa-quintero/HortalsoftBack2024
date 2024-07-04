package com.hortalsoft.users.domain.mapper;

import org.modelmapper.ModelMapper;

import java.util.List;

public class MapperUserToAssociation <User, Association> {
    private static final ModelMapper mapper = new ModelMapper();

    public Association mapToAssociation(User user, Class<Association> association) {
        return mapper.map(user, association);
    }

    public List<Association> mapToAssociationList(List<User> userList, Class<Association> associationList) {
        return userList.parallelStream()
                .map(entity -> mapToAssociation(entity, associationList))
                .toList();
    }
}
