package com.hortalsoft.users.domain.domain;

import com.hortalsoft.users.util.UserType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Association extends User implements Serializable {
    private String name;

    public Association(Integer idUser, Integer documentType, long idNumber, String username, long phoneNumber, String email, String address, String city,String name) {
        super(idUser, documentType, idNumber, username, phoneNumber, email, address, city, UserType.ASSOCIATION);
        this.name = name;
    }
}
