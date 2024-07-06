package com.hortalsoft.users.domain.specification.user;

import com.hortalsoft.crosscutting.specificaction.AbstractSpecification;
import com.hortalsoft.users.domain.entity.UserEntity;
import com.hortalsoft.users.domain.repository.UserRepository;

import java.util.Objects;
import java.util.Optional;


public class UniqueIdNumberSpec extends AbstractSpecification<Integer> {
    private final UserRepository userRepository;

    public UniqueIdNumberSpec(UserRepository userRepository) {
        this.userRepository = userRepository;
    }



    @Override
    public boolean isSatisfiedBy(Integer idNumber) {
        Optional<UserEntity> existingOffer = userRepository.findByIdNumber(idNumber);
        return existingOffer.filter(entity -> Objects.equals(entity.getIdNumber(), idNumber)).isPresent();
    }
}
