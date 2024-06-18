package com.hortalsoft.users.domain.specification;

import com.hortalsoft.crosscutting.specificaction.AbstractSpecification;
import com.hortalsoft.users.domain.entity.UserEntity;
import com.hortalsoft.users.domain.repository.UserRepository;




public class ValidateUserCreatedSpec extends AbstractSpecification<UserEntity> {
    private final UserRepository userRepository;

    public ValidateUserCreatedSpec(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean isSatisfiedBy(UserEntity user) {
        long idNumber = user.getIdNumber();
        String email = user.getEmail();
        return userRepository.findByEmailAndIdNumber(email,idNumber).isPresent();
    }
}
