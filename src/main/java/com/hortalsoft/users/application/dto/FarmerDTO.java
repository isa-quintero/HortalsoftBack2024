package com.hortalsoft.users.application.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class FarmerDTO extends UserDTO {
    private Integer association;
    private static final String userType = "Farmer";

    @Builder(builderMethodName = "farmerDTOBuilder")
    public FarmerDTO(Integer id, String documentType, long idNumber, String username, long phoneNumber, String email, String address, String city, Integer wallet, String userType,Integer association) {
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
            return new FarmerDTO(id, documentType, idNumber, username, phoneNumber, email, address, city, wallet, userType,association);
        }
    }
}