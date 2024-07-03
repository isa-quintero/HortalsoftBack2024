package com.hortalsoft.users.domain.domain;

import jakarta.persistence.JoinColumn;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Data
@RequiredArgsConstructor
public class Customer extends User implements Serializable {
    private Integer customerId;
    private Integer user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Customer customer = (Customer) o;
        return Objects.equals(customerId, customer.customerId) && Objects.equals(user, customer.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), customerId, user);
    }
}
