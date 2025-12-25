package com.irtiza.lanes.repositories;

import com.irtiza.lanes.models.ProjectMember;
import org.jspecify.annotations.NullMarked;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

@NullMarked
public interface ProjectMemberRepository extends JpaRepository<ProjectMember, String> {
//    List<ProjectMember> findAllByProjectOwnerId(String ownerId);
    List<ProjectMember> findAllByProjectId(String projectId);
    Optional<ProjectMember> findOneByProjectIdAndMemberId(String projectId, String memberId);
    void deleteByProjectIdAndMemberId(String projectId, String memberId);
}
