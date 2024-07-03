package com.hortalsoft.users.domain.specification.user;

import com.hortalsoft.crosscutting.specificaction.AbstractSpecification;
import com.hortalsoft.users.domain.entity.UserEntity;
import com.hortalsoft.users.domain.repository.UserRepository;

import java.util.Objects;
import java.util.Optional;

public class UserExistByEmailSpec extends AbstractSpecification<UserEntity> {
    private final UserRepository userRepository;

    public UserExistByEmailSpec(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean isSatisfiedBy(UserEntity userEntity) {
        Optional<UserEntity> existingOffer = userRepository.findByEmail(userEntity.getEmail());
        return existingOffer.filter(entity -> Objects.equals(entity.getEmail(), userEntity.getEmail())).isPresent();
    }
}
