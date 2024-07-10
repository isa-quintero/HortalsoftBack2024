package com.hortalsoft.users.domain.repository;

import com.hortalsoft.users.domain.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
        Optional<UserEntity> findByEmailAndNumberId(String email, long numberId);
        Optional<UserEntity> findByEmail(String email);
        Optional<UserEntity> findByNumberId(Long numberId);

}
