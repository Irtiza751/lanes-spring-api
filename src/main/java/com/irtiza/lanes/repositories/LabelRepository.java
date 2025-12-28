package com.irtiza.lanes.repositories;

import com.irtiza.lanes.models.Label;
import org.jspecify.annotations.NullMarked;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

@NullMarked
public interface LabelRepository extends JpaRepository<Label, String> {
    List<Label> findAllByProjectId(String projectId);
    Optional<Label> findByProjectIdAndId(String projectId, String id);
}
