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
@Table(name = "Association")
public class AssociationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @Transient
    private DocumentType documentType;
    private long idNumber;
    private String code;
    private String name;
    private long phoneNumber;
    private String email;
    private String address;
    private String city;

}
