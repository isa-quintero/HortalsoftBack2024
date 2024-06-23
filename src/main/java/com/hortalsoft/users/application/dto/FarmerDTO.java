package com.hortalsoft.users.application.dto;

import com.hortalsoft.users.util.UserType;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import static com.hortalsoft.users.util.UserType.FARMER;

@Data
@EqualsAndHashCode(callSuper = true)
public class FarmerDTO extends UserDTO {
    private Integer association;
    private static final UserType userType = FARMER;

    @Builder(builderMethodName = "farmerDTOBuilder")
    public FarmerDTO(Integer id, String documentType, long idNumber, String username, long phoneNumber, String email, String address, String city, Integer wallet,Integer association) {
        super(id, documentType, idNumber, username, phoneNumber, email, address, city, wallet,userType);
        this.association = association;
    }

    public static class FarmerDTOBuilder extends UserDTO.UserDTOBuilder {
        private Integer association;

        public FarmerDTOBuilder association(Integer association) {
            this.association = association;
            return this;
        }

        @Override
        public FarmerDTO build() {
            return new FarmerDTO(id, documentType, idNumber, username, phoneNumber, email, address, city, wallet,association);
        }
    }
}