package com.hortalsoft.users.domain.specification;

import com.hortalsoft.crosscutting.specificaction.AbstractSpecification;
import com.hortalsoft.users.domain.entity.UserEntity;
import com.hortalsoft.users.domain.repository.UserRepository;

public class UniqueEmailForUserSpec extends AbstractSpecification<UserEntity> {
    private final UserRepository userRepository;

    public UniqueEmailForUserSpec(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public boolean isSatisfiedBy(UserEntity user) {
        String email = user.getEmail();
        return userRepository.findByEmail(email).isEmpty();

    }
}
