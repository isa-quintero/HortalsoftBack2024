package com.hortalsoft.users.domain.mapper;

import org.modelmapper.ModelMapper;

import java.util.List;

public class MapperUserToFarmer<User, Farmer> {
    private static final ModelMapper mapper = new ModelMapper();

    public Farmer mapToFarmer(User user, Class<Farmer> farmer) {
        return mapper.map(user, farmer);
    }

    public List<Farmer> mapToAssociationList(List<User> userList, Class<Farmer> farmerList) {
        return userList.parallelStream()
                .map(entity -> mapToFarmer(entity, farmerList))
                .toList();
    }
}
