package com.irtiza.lanes.repositories;

import com.irtiza.lanes.dtos.IssueResponseDto;
import com.irtiza.lanes.models.Issue;
import org.jspecify.annotations.NullMarked;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@NullMarked
public interface IssueRepository extends JpaRepository<Issue, String> {
    List<Issue> findByProjectId(String id);
}
