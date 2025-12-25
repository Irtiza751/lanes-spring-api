package com.irtiza.lanes.repositories;

import com.irtiza.lanes.models.Sprint;
import org.jspecify.annotations.NullMarked;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@NullMarked
public interface SprintRepository extends JpaRepository<Sprint, String> {
    List<Sprint> findAllByProjectId(String projectId);
}
