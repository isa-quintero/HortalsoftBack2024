package com.hortalsoft.users.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@Entity
@ToString
@RequiredArgsConstructor
@Table(name = "DocumentType")
public class DocumentTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private String id;
    private String code;
    private String name;
    private String description;
}
