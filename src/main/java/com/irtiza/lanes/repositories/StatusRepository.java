package com.irtiza.lanes.repositories;

import com.irtiza.lanes.models.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StatusRepository extends JpaRepository<Status, String> {
    List<Status> findAllByProjectId(String projectId);
    Optional<Status> findByProjectIdAndId(String projectId, String statusId);
}
