package com.irtiza.lanes.repositories;

import com.irtiza.lanes.models.Issue;
import org.jspecify.annotations.NullMarked;
import org.springframework.data.jpa.repository.JpaRepository;

@NullMarked
public interface IssueRepository extends JpaRepository<Issue, String> {
}
