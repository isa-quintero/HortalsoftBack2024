package com.hortalsoft.users.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "association", schema = "users")
@EqualsAndHashCode(callSuper = true)
public class AssociationEntity extends UserEntity {
}
