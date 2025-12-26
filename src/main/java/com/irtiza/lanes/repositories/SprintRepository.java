package com.irtiza.lanes.repositories;

import com.irtiza.lanes.models.Sprint;
import org.jspecify.annotations.NullMarked;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

@NullMarked
public interface SprintRepository extends JpaRepository<Sprint, String> {
    List<Sprint> findAllByProjectId(String projectId);
    Optional<Sprint> findByProjectIdAndId(String projectId, String id);
}
