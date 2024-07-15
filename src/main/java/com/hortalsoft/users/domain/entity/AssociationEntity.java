package com.hortalsoft.users.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "association", schema = "users")
@DiscriminatorValue("ASSOCIATION")
@PrimaryKeyJoinColumn(name = "id_user")
public class AssociationEntity extends UserEntity {
    @Column(name = "association_name")
    private String name;
}
