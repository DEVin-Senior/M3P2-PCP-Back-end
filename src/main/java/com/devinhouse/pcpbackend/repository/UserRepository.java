package com.devinhouse.pcpbackend.repository;

import com.devinhouse.pcpbackend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
