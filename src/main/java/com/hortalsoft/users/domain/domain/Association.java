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

    public Association(Integer id, Integer documentType, long idNumber, String username, long phoneNumber, String email, String address, String city) {
        super(id, documentType, idNumber, username, phoneNumber, email, address, city, UserType.ASSOCIATION);
    }
}
