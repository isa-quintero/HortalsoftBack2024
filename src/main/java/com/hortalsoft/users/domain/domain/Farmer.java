package com.hortalsoft.users.domain.domain;

import com.hortalsoft.users.util.UserType;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


@NoArgsConstructor
public class Farmer extends User implements Serializable {
    @Getter
    @Setter
    private Integer associationId;

    public Farmer(Integer idUser, Integer documentType, long numberId, String username, long phoneNumber, String email, String address, String city,Integer associationId) {
        super(idUser, documentType, numberId, username, phoneNumber, email, address, city, UserType.FARMER);
        this.associationId = associationId;
    }
}
