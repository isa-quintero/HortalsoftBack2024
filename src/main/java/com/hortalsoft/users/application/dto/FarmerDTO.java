package com.hortalsoft.users.application.dto;

import com.hortalsoft.users.util.UserType;
import lombok.*;

import static com.hortalsoft.users.util.UserType.FARMER;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FarmerDTO extends UserDTO {
    private Integer association;

}