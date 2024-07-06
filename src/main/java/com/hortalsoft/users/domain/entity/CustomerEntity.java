package com.hortalsoft.users.domain.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "customer", schema = "users")
@DiscriminatorValue("CUSTOMER")
@PrimaryKeyJoinColumn(name = "id_user")
public class CustomerEntity extends UserEntity {

}
