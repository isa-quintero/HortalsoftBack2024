package com.hortalsoft.users.domain.domain;

import jakarta.persistence.JoinColumn;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Data
@RequiredArgsConstructor
public class Association extends User implements Serializable {
    private Integer associationId;
    private Integer user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Association that = (Association) o;
        return Objects.equals(associationId, that.associationId) && Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), associationId, user);
    }
}
