package com.hortalsoft.users.domain.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "association", schema = "users")
@PrimaryKeyJoinColumn(name = "id_user")
public class AssociationEntity extends UserEntity {
}
