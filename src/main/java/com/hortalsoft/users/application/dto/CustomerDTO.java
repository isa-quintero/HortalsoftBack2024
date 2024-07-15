package com.hortalsoft.users.application.dto;

import lombok.*;

import static com.hortalsoft.users.util.UserType.CUSTOMER;

@Getter
@Setter
@AllArgsConstructor
public class CustomerDTO extends UserDTO {
    public CustomerDTO(Integer idUser, Integer documentType, long numberId, String username, long phoneNumber, String email, String address, String city) {
        super(idUser, documentType, numberId, username, phoneNumber, email, address, city, CUSTOMER);
    }
}
