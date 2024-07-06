package com.hortalsoft.users.application.dto;

import lombok.*;

import static com.hortalsoft.users.util.UserType.ASSOCIATION;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AssociationDTO extends UserDTO {
    private String name;
    public AssociationDTO(Integer id, Integer documentType, long idNumber, String username, long phoneNumber, String email, String address, String city, String name) {
        super(id, documentType, idNumber, username, phoneNumber, email, address, city, ASSOCIATION);
        this.name = name;
    }

}
