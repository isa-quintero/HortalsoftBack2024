package com.hortalsoft.users.application.dto;

import com.hortalsoft.users.util.UserType;
import lombok.*;

import static com.hortalsoft.users.util.UserType.ASSOCIATION;

@Getter
@Setter
@AllArgsConstructor
public class AssociationDTO extends UserDTO {
    public AssociationDTO(Integer id, Integer documentType, long idNumber, String username, long phoneNumber, String email, String address, String city) {
        super(id, documentType, idNumber, username, phoneNumber, email, address, city, ASSOCIATION);
    }

}
