package com.hortalsoft.users.application.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class FarmerDTO extends UserDTO {
    private Integer association;

    @Builder(builderMethodName = "farmerDTOBuilder")
    public FarmerDTO(Integer id, String documentType, long idNumber, String username, long phoneNumber, String email, String address, String city, Integer wallet, Integer association) {
        super(id, documentType, idNumber, username, phoneNumber, email, address, city, wallet);
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
            return new FarmerDTO(id, documentType, idNumber, username, phoneNumber, email, address, city, wallet, association);
        }
    }
}