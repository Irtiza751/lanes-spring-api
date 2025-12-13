package com.irtiza.lanes.repositories;

import com.irtiza.lanes.models.Sprint;
import org.jspecify.annotations.NullMarked;
import org.springframework.data.jpa.repository.JpaRepository;

@NullMarked
public interface SprintRepository extends JpaRepository<Sprint, String> {
}
