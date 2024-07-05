package com.hortalsoft.users.domain.specification.user;

import com.hortalsoft.crosscutting.specificaction.AbstractSpecification;
import com.hortalsoft.users.domain.entity.UserEntity;
import com.hortalsoft.users.domain.repository.UserRepository;

import java.util.Objects;
import java.util.Optional;

public class UserExistByEmailSpec extends AbstractSpecification<String> {
    private final UserRepository userRepository;

    public UserExistByEmailSpec(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean isSatisfiedBy(String email) {
        Optional<UserEntity> existingOffer = userRepository.findByEmail(email);
        return existingOffer.filter(entity -> Objects.equals(entity.getEmail(), email)).isPresent();
    }
}
