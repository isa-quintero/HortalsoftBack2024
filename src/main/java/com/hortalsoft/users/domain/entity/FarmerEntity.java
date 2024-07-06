package com.hortalsoft.users.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "farmer", schema = "users")
@DiscriminatorValue("FARMER")
@PrimaryKeyJoinColumn(name = "id_user")
public class FarmerEntity extends UserEntity {
    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "association_id")
    private AssociationEntity association;

}
