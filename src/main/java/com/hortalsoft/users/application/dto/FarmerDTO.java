package com.hortalsoft.users.application.dto;

import com.hortalsoft.users.util.UserType;
import lombok.*;

import static com.hortalsoft.users.util.UserType.FARMER;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FarmerDTO extends UserDTO {
    private Integer association;

    public FarmerDTO(Integer id, Integer documentType, long idNumber, String username, long phoneNumber, String email, String address, String city, UserType userType, Integer association) {
        super(id, documentType, idNumber, username, phoneNumber, email, address, city, userType);
        this.association = association;
    }
}