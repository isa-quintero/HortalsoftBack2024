package com.hortalsoft.users.domain.domain;

import com.hortalsoft.users.util.UserType;
import lombok.*;

import java.io.Serializable;


@Data
@RequiredArgsConstructor
public class User implements Serializable {
    private Integer id;
    private String documentType;
    private long idNumber;
    private String username;
    private long phoneNumber;
    private String email;
    private String address;
    private String city;
    private UserType userType;

}
