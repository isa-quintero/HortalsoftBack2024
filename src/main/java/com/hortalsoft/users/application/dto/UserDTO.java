package com.hortalsoft.users.application.dto;

import com.hortalsoft.crosscutting.helper.ObjectHelper;
import com.hortalsoft.crosscutting.helper.TextHelper;
import com.hortalsoft.users.util.UserType;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Integer id;

    private String documentType;

    @Setter
    @Getter
    private long idNumber; // idNumber is a primitive type, no need for null check

    private String username;

    @Setter
    @Getter
    private long phoneNumber; // phoneNumber is a primitive type, no need for null check

    private String email;

    private String address;

    private String city;

    private UserType userType;

    // Setters using helpers
    public void setId(Integer id) {
        this.id = ObjectHelper.getDefaultInteger(id);
    }

    public void setDocumentType(String documentType) {
        this.documentType = TextHelper.getDefault(documentType);
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


    public void setUserType(UserType userType) {
        this.userType = ObjectHelper.getDefault(userType, UserType.CUSTOMER); // Default to CUSTOMER if null
    }

    // Getters using helpers
    public Integer getId() {
        return ObjectHelper.getDefaultInteger(id);
    }

    public String getDocumentType() {
        return TextHelper.getDefault(documentType);
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

    // Methods to check user type
    public boolean isFarmer() {
        return UserType.FARMER.equals(this.userType);
    }

    public boolean isCustomer() {
        return UserType.CUSTOMER.equals(this.userType);
    }

    public boolean isAssociation() {
        return UserType.ASSOCIATION.equals(this.userType);
    }
}

