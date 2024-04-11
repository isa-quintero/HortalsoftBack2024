package com.hortalSoft.users.backend.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@Entity
@ToString
@SuperBuilder
@RequiredArgsConstructor
public class Association {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private String id;
    private DocumentType documentType;
    private long idNumber;
    private String code;
    private String name;
    private long phoneNumber;
    private String email;
    private String address;
    private String city;
}
