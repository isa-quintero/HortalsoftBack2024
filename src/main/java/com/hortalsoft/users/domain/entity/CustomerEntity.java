package com.hortalsoft.users.domain.entity;

import com.hortalsoft.users.domain.domain.DocumentType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;


@Data
@Entity
@ToString
@RequiredArgsConstructor
@Table(name = "Customer")
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private long id;
    @Transient
    private DocumentType documentType;
    private long idNumber;
    private String name;
    private String lastname;
    private long phoneNumber;
    private String email;
    private String address;
    private String city;
}
