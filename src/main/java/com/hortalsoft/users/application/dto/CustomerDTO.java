package com.hortalsoft.users.application.dto;

import com.hortalsoft.users.util.UserType;
import jakarta.persistence.JoinColumn;
import lombok.*;

import static com.hortalsoft.users.util.UserType.CUSTOMER;

@Getter
@Setter
@AllArgsConstructor
public class CustomerDTO extends UserDTO {
    public CustomerDTO(Integer id, Integer documentType, long idNumber, String username, long phoneNumber, String email, String address, String city, UserType userType) {
        super(id, documentType, idNumber, username, phoneNumber, email, address, city, userType);
    }
}
