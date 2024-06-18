package com.hortalsoft.users.domain.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Farmer extends User{
    private Integer association;
}
