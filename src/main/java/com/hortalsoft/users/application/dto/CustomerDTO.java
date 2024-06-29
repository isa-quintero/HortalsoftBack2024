package com.hortalsoft.users.application.dto;

import com.hortalsoft.users.util.UserType;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import static com.hortalsoft.users.util.UserType.CUSTOMER;

@Data
@EqualsAndHashCode(callSuper = true)
public class CustomerDTO extends UserDTO {
    private static final UserType userType = CUSTOMER;
    @Builder(builderMethodName = "customerDTOBuilder")
    public CustomerDTO(Integer id, String documentType, long idNumber, String username, long phoneNumber, String email, String address, String city) {
        super(id, documentType, idNumber, username, phoneNumber, email, address, city,userType);
    }

    public static class CustomerDTOBuilder extends UserDTO.UserDTOBuilder {
        @Override
        public CustomerDTO build() {
            return new CustomerDTO(id, documentType, idNumber, username, phoneNumber, email, address, city);
        }
    }
}
