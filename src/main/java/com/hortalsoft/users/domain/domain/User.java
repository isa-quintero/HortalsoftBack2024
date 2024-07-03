package com.hortalsoft.users.domain.domain;

import com.hortalsoft.users.util.UserType;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;


@Data
@RequiredArgsConstructor
public abstract class User implements Serializable {
    private Integer id;
    private Integer documentType;
    private long idNumber;
    private String username;
    private long phoneNumber;
    private String email;
    private String address;
    private String city;
    private UserType userType;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return idNumber == user.idNumber && phoneNumber == user.phoneNumber && Objects.equals(id, user.id) && Objects.equals(documentType, user.documentType) && Objects.equals(username, user.username) && Objects.equals(email, user.email) && Objects.equals(address, user.address) && Objects.equals(city, user.city) && userType == user.userType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, documentType, idNumber, username, phoneNumber, email, address, city, userType);
    }
}
