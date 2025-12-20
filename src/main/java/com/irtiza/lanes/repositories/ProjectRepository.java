package com.irtiza.lanes.repositories;

import com.irtiza.lanes.models.Project;
import org.jspecify.annotations.NullMarked;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@NullMarked
public interface ProjectRepository extends JpaRepository<Project, String> {
    List<Project> findByOwnerId(String userId);
}
