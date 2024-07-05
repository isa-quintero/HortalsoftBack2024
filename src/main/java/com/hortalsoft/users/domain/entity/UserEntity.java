package com.hortalsoft.users.domain.entity;

import com.hortalsoft.users.util.UserType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "user_type", discriminatorType = DiscriminatorType.STRING)
@Table(name = "user", schema = "users")
public abstract class UserEntity {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users.user_seq")
    @SequenceGenerator(name = "users.user_seq", sequenceName = "users.user_seq", allocationSize = 1)
    @Column(name = "id_user")
    private Integer id;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "id_document_type")
    private DocumentTypeEntity documentType;

    @Getter
    @Setter
    @Column(name = "id_number")
    private long idNumber;

    @Getter
    @Setter
    @Column(name = "username")
    private String username;

    @Getter
    @Setter
    @Column(name = "phone_number")
    private long phoneNumber;

    @Getter
    @Setter
    @Column(name = "email")
    private String email;

    @Getter
    @Setter
    @Column(name = "address")
    private String address;

    @Getter
    @Setter
    @Column(name = "city")
    private String city;

    @Setter
    @Getter
    @Enumerated(EnumType.STRING)
    @Column(name = "user_type", insertable = false, updatable = false)
    private UserType userType;

}
