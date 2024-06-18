package com.hortalsoft.users.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "farmer", schema = "users")
@EqualsAndHashCode(callSuper = true)
public class FarmerEntity extends UserEntity {
    @ManyToOne
    @JoinColumn(name = "association_id")
    private AssociationEntity association;
}
