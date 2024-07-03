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
    @Column(name = "id_document_type")
    private Integer idDocumentType;
    @Column(name = "code")
    private String code;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
}
