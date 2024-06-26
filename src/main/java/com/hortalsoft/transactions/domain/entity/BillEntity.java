package com.hortalsoft.transactions.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@Entity
@ToString
@RequiredArgsConstructor
public class BillEntity {

    @Id
    private int id;
}
