package com.hortalsoft.users.domain.domain;

import com.hortalsoft.users.util.UserType;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class Farmer extends User implements Serializable {
    private Integer associationId;

    public Farmer(Integer id, Integer documentType, long idNumber, String username, long phoneNumber, String email, String address, String city,Integer associationId) {
        super(id, documentType, idNumber, username, phoneNumber, email, address, city, UserType.FARMER);
        this.associationId = associationId;
    }
}
