package com.hortalsoft.users.domain.entity;

import com.hortalsoft.users.util.UserType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;


@Data
@Entity
@ToString
@RequiredArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "user", schema = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_user")
    private Integer id;
    @Column(name = "document_type")
    private String documentType;
    @Column(name = "id_number")
    private long idNumber;
    @Column(name = "username")
    private String username;
    @Column(name = "phone_number")
    private long phoneNumber;
    @Column(name = "email")
    private String email;
    @Column(name = "address")
    private String address;
    @Column(name = "city")
    private String city;
    private UserType userType;

}
