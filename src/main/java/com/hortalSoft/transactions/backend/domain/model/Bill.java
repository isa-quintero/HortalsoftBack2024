package com.hortalsoft.transactions.backend.domain.model;

import com.hortalsoft.users.backend.domain.model.Farmer;
import com.hortalsoft.users.backend.domain.model.Customer;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Getter
@Setter
@Entity
@ToString
@SuperBuilder
@RequiredArgsConstructor
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private String id;
    private Date date;
    private Customer customer;
    private Farmer farmer;
    private String description;
    private int total;

}
