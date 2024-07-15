package com.hortalsoft.users.application.dto;

import com.hortalsoft.crosscutting.helper.TextHelper;
import lombok.*;

import static com.hortalsoft.users.util.UserType.ASSOCIATION;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AssociationDTO extends UserDTO {
    private String name;
    public AssociationDTO(Integer idUser, Integer documentType, long numberId, String username, long phoneNumber, String email, String address, String city, String name) {
        super(idUser, documentType, numberId, username, phoneNumber, email, address, city, ASSOCIATION);
        this.name = name;
    }

    public void setName(String name) {
        this.name = TextHelper.getDefault(name);
    }
}
