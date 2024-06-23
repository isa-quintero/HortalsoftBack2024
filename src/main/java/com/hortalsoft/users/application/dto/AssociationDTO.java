package com.hortalsoft.users.application.dto;

import com.hortalsoft.users.util.UserType;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import static com.hortalsoft.users.util.UserType.ASSOCIATION;

@Data
@EqualsAndHashCode(callSuper = true)
public class AssociationDTO extends UserDTO {
    private static final UserType userType = ASSOCIATION;
    @Builder(builderMethodName = "associationDTOBuilder")
    public AssociationDTO(Integer id, String documentType, long idNumber, String username, long phoneNumber, String email, String address, String city, Integer wallet) {
        super(id, documentType, idNumber, username, phoneNumber, email, address, city, wallet,userType);
    }

    public static class AssociationDTOBuilder extends UserDTO.UserDTOBuilder {
        @Override
        public CustomerDTO build() {
            return new CustomerDTO(id, documentType, idNumber, username, phoneNumber, email, address, city, wallet);
        }
    }
}
