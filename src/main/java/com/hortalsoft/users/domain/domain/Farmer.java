package com.hortalsoft.users.domain.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Objects;

@Data
public class Farmer extends User implements Serializable {
    private Integer farmerId;
    private Integer association;
    private Integer user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Farmer farmer = (Farmer) o;
        return Objects.equals(farmerId, farmer.farmerId) && Objects.equals(association, farmer.association) && Objects.equals(user, farmer.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), farmerId, association, user);
    }
}
