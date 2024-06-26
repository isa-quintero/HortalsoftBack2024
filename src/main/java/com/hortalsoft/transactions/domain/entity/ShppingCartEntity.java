package com.hortalsoft.transactions.domain.entity;

import jakarta.persistence.*;
import lombok.*;


@Data
@Entity
@ToString
@RequiredArgsConstructor

public class ShppingCartEntity {
    @Id
    private int id;
}

