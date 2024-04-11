package com.hortalsoft.transactions.backend.application.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WalletDTO {

    private String id;
    private String walletAddress;
    private String name;
    private String email;
    private long balance;
}
