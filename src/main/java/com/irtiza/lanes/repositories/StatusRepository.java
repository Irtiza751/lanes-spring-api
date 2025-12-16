package com.irtiza.lanes.repositories;

import com.irtiza.lanes.models.Status;
import org.jspecify.annotations.NullMarked;
import org.springframework.data.jpa.repository.JpaRepository;

@NullMarked
public interface StatusRepository extends JpaRepository<Status, String> {
}
