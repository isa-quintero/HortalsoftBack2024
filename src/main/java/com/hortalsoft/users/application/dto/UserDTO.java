package com.hortalsoft.users.application.dto;

import com.hortalsoft.users.util.UserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Integer id;
    private String documentType;
    private long idNumber;
    private String username;
    private long phoneNumber;
    private String email;
    private String address;
    private String city;
    private Integer wallet;
    private UserType userType;

    public static class UserDTOBuilder {
    }
    public boolean isFarmer(){
        return userType.FARMER.equals(this.userType);
    }
    public boolean isCustomer(){
        return userType.CUSTOMER.equals(this.userType);
    }
    public boolean isAssociation(){
        return userType.ASSOCIATION.equals(this.userType);
    }
}
