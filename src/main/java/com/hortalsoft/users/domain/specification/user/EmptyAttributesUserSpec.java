package com.hortalsoft.users.domain.specification.user;

import com.hortalsoft.crosscutting.specificaction.AbstractSpecification;
import com.hortalsoft.users.domain.entity.UserEntity;

import java.util.Objects;


public class EmptyAttributesUserSpec extends AbstractSpecification<UserEntity> {

    @Override
    public boolean isSatisfiedBy(UserEntity user) {
        return (Objects.equals(user.getDocumentType(), 0) || Objects.equals(user.getNumberId(), 0)
                || Objects.equals(user.getUsername(), "") || Objects.equals(user.getPhoneNumber(), 0)
                || Objects.equals(user.getEmail(), "") || Objects.equals(user.getAddress(), "")
                || Objects.equals(user.getCity(), ""));
    }
}
