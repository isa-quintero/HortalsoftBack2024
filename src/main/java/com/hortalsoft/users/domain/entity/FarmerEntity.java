package com.hortalsoft.users.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "farmer", schema = "users")
@PrimaryKeyJoinColumn(name = "id_user")
public class FarmerEntity extends UserEntity {
    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "association_id", referencedColumnName = "id_user")
    private AssociationEntity association;

}
