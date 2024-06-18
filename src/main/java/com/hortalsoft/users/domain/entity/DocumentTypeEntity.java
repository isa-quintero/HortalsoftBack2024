package com.hortalsoft.users.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;



@Data
@Entity
@ToString
@RequiredArgsConstructor
@Table(name = "document_type", schema = "users")
public class DocumentTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Column(name = "id_user")
    private String code;
    @Column(name = "id_user")
    private String name;
    @Column(name = "id_user")
    private String description;
}
