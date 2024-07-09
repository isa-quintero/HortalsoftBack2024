package com.hortalsoft.users.domain.domain;

import com.hortalsoft.users.util.UserType;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Data
@RequiredArgsConstructor
public class Customer extends User implements Serializable {
    public Customer(Integer idUser, Integer documentType, long idNumber, String username, long phoneNumber, String email, String address, String city) {
        super(idUser, documentType, idNumber, username, phoneNumber, email, address, city, UserType.CUSTOMER);
    }
}
