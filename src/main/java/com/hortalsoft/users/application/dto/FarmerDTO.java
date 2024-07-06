package com.hortalsoft.users.application.dto;

import lombok.*;

import static com.hortalsoft.users.util.UserType.FARMER;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FarmerDTO extends UserDTO {
    private Integer associationId;

    public FarmerDTO(Integer id, Integer documentType, long idNumber, String username, long phoneNumber, String email, String address, String city, Integer associationId) {
        super(id, documentType, idNumber, username, phoneNumber, email, address, city, FARMER);
        this.associationId = associationId;
    }
}