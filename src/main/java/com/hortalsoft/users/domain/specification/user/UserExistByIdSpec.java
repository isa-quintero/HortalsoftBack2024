package com.hortalsoft.users.domain.specification.user;

import com.hortalsoft.crosscutting.specificaction.AbstractSpecification;
import com.hortalsoft.users.domain.entity.UserEntity;
import com.hortalsoft.users.domain.repository.UserRepository;

import java.util.Objects;
import java.util.Optional;

public class UserExistByIdSpec extends AbstractSpecification<UserEntity> {
    private final UserRepository userRepository;

    public UserExistByIdSpec(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean isSatisfiedBy(UserEntity userEntity) {
        Optional<UserEntity> existingOffer = userRepository.findById(userEntity.getId());
        return existingOffer.filter(entity -> Objects.equals(entity.getId(), userEntity.getId())).isPresent();
    }
}
