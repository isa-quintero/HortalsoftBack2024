package com.hortalsoft.users.domain.domain;

import com.hortalsoft.users.util.UserType;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@NoArgsConstructor
@Getter
@Setter
public abstract class User implements Serializable {
    private Integer idUser;
    private Integer documentTypeId;
    private long numberId;
    private String username;
    private long phoneNumber;
    private String email;
    private String address;
    private String city;
    private UserType userType;

    public User(Integer idUser, Integer documentTypeId, long numberId, String username, long phoneNumber, String email, String address, String city, UserType userType) {
        this.idUser = idUser;
        this.documentTypeId = documentTypeId;
        this.numberId = numberId;
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
        return numberId == user.numberId &&
                phoneNumber == user.phoneNumber &&
                Objects.equals(idUser, user.idUser) &&
                Objects.equals(documentTypeId, user.documentTypeId) &&
                Objects.equals(username, user.username) &&
                Objects.equals(email, user.email) &&
                Objects.equals(address, user.address) &&
                Objects.equals(city, user.city) &&
                userType == user.userType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUser, documentTypeId, numberId, username, phoneNumber, email, address, city, userType);
    }
}
