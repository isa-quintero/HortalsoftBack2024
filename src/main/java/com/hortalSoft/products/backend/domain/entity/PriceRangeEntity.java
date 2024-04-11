package com.hortalsoft.products.backend.domain.entity;

import com.hortalsoft.users.backend.domain.model.Association;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@Entity
@ToString
//@Builder
@RequiredArgsConstructor
@Table(name = "PriceRange")
public class PriceRangeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private long id;
    @ManyToOne(fetch = FetchType.LAZY,targetEntity = ProductEntity.class)
    private ProductEntity productEntity;
    @ManyToOne(fetch = FetchType.LAZY,targetEntity = Association.class)
    private Association association;
    private float initialRange;
    private float finalRange;
    private Date initialDate;
    private Date finalDate;
    private int validity;
}
