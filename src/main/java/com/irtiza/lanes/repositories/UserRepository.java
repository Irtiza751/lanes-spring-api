package com.irtiza.lanes.repositories;

import com.irtiza.lanes.models.User;
import org.jspecify.annotations.NullMarked;
import org.springframework.data.jpa.repository.JpaRepository;

@NullMarked
public interface UserRepository extends JpaRepository<User, String> {
}
