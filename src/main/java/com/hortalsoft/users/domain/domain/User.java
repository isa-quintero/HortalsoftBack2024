package com.hortalsoft.users.domain.domain;

import com.hortalsoft.users.util.UserType;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@NoArgsConstructor

public abstract class User implements Serializable {
    @Getter
    @Setter
    private Integer id;
    @Getter
    @Setter
    private Integer documentTypeId;
    @Getter
    @Setter
    private long idNumber;
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

    public User(Integer id, Integer documentTypeId, long idNumber, String username, long phoneNumber, String email, String address, String city, UserType userType) {
        this.id = id;
        this.documentTypeId = documentTypeId;
        this.idNumber = idNumber;
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.city = city;
        this.userType = userType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return idNumber == user.idNumber &&
                phoneNumber == user.phoneNumber &&
                Objects.equals(id, user.id) &&
                Objects.equals(documentTypeId, user.documentTypeId) &&
                Objects.equals(username, user.username) &&
                Objects.equals(email, user.email) &&
                Objects.equals(address, user.address) &&
                Objects.equals(city, user.city) &&
                userType == user.userType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, documentTypeId, idNumber, username, phoneNumber, email, address, city, userType);
    }
}
