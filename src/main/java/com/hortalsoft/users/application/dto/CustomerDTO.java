package com.hortalsoft.users.application.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CustomerDTO extends UserDTO {

    @Builder(builderMethodName = "customerDTOBuilder")
    public CustomerDTO(Integer id, String documentType, long idNumber, String username, long phoneNumber, String email, String address, String city, Integer wallet) {
        super(id, documentType, idNumber, username, phoneNumber, email, address, city, wallet);
    }

    public static class CustomerDTOBuilder extends UserDTO.UserDTOBuilder {
        @Override
        public CustomerDTO build() {
            return new CustomerDTO(id, documentType, idNumber, username, phoneNumber, email, address, city, wallet);
        }
    }
}
