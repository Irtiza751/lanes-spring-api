package com.irtiza.lanes.repositories;

import com.irtiza.lanes.models.ProjectMember;
import org.jspecify.annotations.NullMarked;
import org.springframework.data.jpa.repository.JpaRepository;

@NullMarked
public interface ProjectMemberRepository extends JpaRepository<ProjectMember, String> {
}
