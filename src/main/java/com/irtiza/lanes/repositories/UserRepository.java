package com.irtiza.lanes.repositories;

import com.irtiza.lanes.models.User;
import org.jspecify.annotations.NullMarked;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@NullMarked
public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByEmail(String email);
}
