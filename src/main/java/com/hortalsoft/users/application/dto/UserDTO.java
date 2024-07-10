package com.hortalsoft.users.application.dto;

import com.hortalsoft.crosscutting.helper.ObjectHelper;
import com.hortalsoft.crosscutting.helper.TextHelper;
import com.hortalsoft.users.util.UserType;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
public abstract class UserDTO {
    @Getter
    @Setter
    private Integer idUser;
    @Getter
    @Setter
    private Integer documentTypeId;
    @Getter
    @Setter
    private long numberId;
    @Getter
    @Setter
    private String username;
    @Getter
    @Setter
    private long phoneNumber;
    @Getter
    @Setter
    private String email;
    @Getter
    @Setter
    private String address;
    @Getter
    @Setter
    private String city;
    @Setter
    @Getter
    private UserType userType;


    // Setters using helpers
    public void setIdUser(Integer idUser) {
        this.idUser = ObjectHelper.getDefaultInteger(idUser);
    }

    public void setDocumentTypeId(Integer documentTypeId) {
        this.documentTypeId = ObjectHelper.getDefaultInteger(documentTypeId);
    }

    public void setUsername(String username) {
        this.username = TextHelper.getDefault(username);
    }

    public void setEmail(String email) {
        this.email = TextHelper.getDefault(email);
    }

    public void setAddress(String address) {
        this.address = TextHelper.getDefault(address);
    }

    public void setCity(String city) {
        this.city = TextHelper.getDefault(city);
    }


//    public void setUserType(UserType userType) {
//        this.userType = ObjectHelper.getDefault(userType, UserType.CUSTOMER); // Default to CUSTOMER if null
//    }

    // Getters using helpers
    public Integer getIdUser() {
        return ObjectHelper.getDefaultInteger(idUser);
    }

    public Integer getDocumentTypeId() {
        return ObjectHelper.getDefaultInteger(documentTypeId);
    }

    public String getUsername() {
        return TextHelper.getDefault(username);
    }

    public String getEmail() {
        return TextHelper.getDefault(email);
    }

    public String getAddress() {
        return TextHelper.getDefault(address);
    }

    public String getCity() {
        return TextHelper.getDefault(city);
    }

    public UserType getUserType() {
        return ObjectHelper.getDefault(userType, UserType.CUSTOMER); // Default to CUSTOMER if null
    }

//    // Methods to check user type
//    public boolean isFarmer() {
//        return UserType.FARMER.equals(this.userType);
//    }
//
//    public boolean isCustomer() {
//        return UserType.CUSTOMER.equals(this.userType);
//    }
//
//    public boolean isAssociation() {
//        return UserType.ASSOCIATION.equals(this.userType);
//    }
}

