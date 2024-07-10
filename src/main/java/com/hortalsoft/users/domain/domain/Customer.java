package com.hortalsoft.users.domain.domain;

import com.hortalsoft.users.util.UserType;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


@RequiredArgsConstructor
public class Customer extends User implements Serializable {
    public Customer(Integer idUser, Integer documentType, long numberId, String username, long phoneNumber, String email, String address, String city) {
        super(idUser, documentType, numberId, username, phoneNumber, email, address, city, UserType.CUSTOMER);
    }
}
