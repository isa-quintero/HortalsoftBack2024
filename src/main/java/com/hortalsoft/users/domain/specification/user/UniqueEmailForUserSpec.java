package com.hortalsoft.users.domain.specification.user;

import com.hortalsoft.crosscutting.specificaction.AbstractSpecification;
import com.hortalsoft.users.domain.repository.UserRepository;

public class UniqueEmailForUserSpec extends AbstractSpecification<String> {
    private final UserRepository userRepository;

    public UniqueEmailForUserSpec(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public boolean isSatisfiedBy(String email) {
        return userRepository.findByEmail(email).isEmpty();
    }
}
