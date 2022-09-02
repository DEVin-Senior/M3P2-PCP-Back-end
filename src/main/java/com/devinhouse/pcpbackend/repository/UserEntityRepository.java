package com.devinhouse.pcpbackend.repository;

import com.devinhouse.pcpbackend.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserEntityRepository extends JpaRepository<UserEntity, Integer> {

    Optional<UserEntity> findByEmail(String email);

    void deleteById(Integer id);

    Boolean existsByEmail(String email);
}
