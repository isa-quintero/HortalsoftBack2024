package com.hortalsoft.users.domain.mapper;

import org.modelmapper.ModelMapper;

import java.util.List;

public class MapperUserToCustomer<User, Customer> {
    private static final ModelMapper mapper = new ModelMapper();

    public Customer mapToCustomer(User user, Class<Customer> customer) {
        return mapper.map(user, customer);
    }

    public List<Customer> mapToCustomerList(List<User> userList, Class<Customer> customerList) {
        return userList.parallelStream()
                .map(entity -> mapToCustomer(entity, customerList))
                .toList();
    }
}
