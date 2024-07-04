package com.hortalsoft.users.domain.entity;

import com.hortalsoft.users.util.UserType;
import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "user_type")
@Table(name = "user", schema = "users")
public abstract class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users.user_seq")
    @SequenceGenerator(name = "users.user_seq", sequenceName = "users.user_seq", allocationSize = 1)
    @Column(name = "id_user")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "document_type", referencedColumnName = "id_document_type")
    private DocumentTypeEntity documentType;

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

    @Enumerated(EnumType.STRING)
    @Column(name = "user_type", insertable = false, updatable = false)
    private UserType userType;

}
