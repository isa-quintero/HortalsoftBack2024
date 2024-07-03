package com.hortalsoft.users.application.dto;

import com.hortalsoft.users.util.UserType;
import jakarta.persistence.JoinColumn;
import lombok.*;

import static com.hortalsoft.users.util.UserType.CUSTOMER;

@Getter
@Setter
@AllArgsConstructor
public class CustomerDTO extends UserDTO {
}
