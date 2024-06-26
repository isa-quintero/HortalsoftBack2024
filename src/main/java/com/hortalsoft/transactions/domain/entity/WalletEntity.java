package com.hortalsoft.transactions.domain.entity;

import com.hortalsoft.products.domain.entity.ProductEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Data
@Entity
@ToString
@RequiredArgsConstructor
public class WalletEntity {
    @Id
    private int id;

}
