package com.hortalsoft.transactions.backend.application.dto;

import com.hortalsoft.users.backend.domain.model.Farmer;
import com.hortalsoft.users.backend.domain.model.Customer;
import lombok.*;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BillDTO {

    private String id;
    private Date date;
    private Customer customer;
    private Farmer farmer;
    private String description;
    private int total;

}
