package com.irtiza.lanes.services;

import com.irtiza.lanes.dtos.CreateProjectMemberDto;
import com.irtiza.lanes.dtos.ProjectMemberResponseDto;
import com.irtiza.lanes.mappers.ProjectMemberMapper;
import com.irtiza.lanes.models.Project;
import com.irtiza.lanes.models.ProjectMember;
import com.irtiza.lanes.models.User;
import com.irtiza.lanes.repositories.ProjectMemberRepository;
import com.irtiza.lanes.repositories.ProjectRepository;
import com.irtiza.lanes.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectMemberService {
    private final ProjectMemberRepository projectMemberRepository;
    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;
    private final ProjectMemberMapper projectMemberMapper;

    @Transactional
    public ProjectMemberResponseDto create(CreateProjectMemberDto projectMemberDto) {
        Project project = projectRepository.findById(projectMemberDto.getProjectId())
                .orElseThrow(() -> new EntityNotFoundException("Project not found"));

        User member = userRepository.findById(projectMemberDto.getUserId())
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        ProjectMember projectMember = ProjectMember.builder()
                .project(project)
                .member(member)
                .role(projectMemberDto.getRole())
                .build();

        project.add(projectMember);
        member.add(projectMember);
        ProjectMember savedProjectMember = projectMemberRepository.save(projectMember);
        return projectMemberMapper.toDto(savedProjectMember);
    }

    public List<ProjectMemberResponseDto> findAllMembers() {
        return projectMemberRepository.findAll()
                .stream()
                .map(projectMemberMapper::toDto)
                .toList();
    }

    public List<ProjectMemberResponseDto> findAllMembersByProject(String projectId) {
        return projectMemberRepository.findAllByProjectId(projectId)
                .stream()
                .map(projectMemberMapper::toDto)
                .toList();
    }

    public ProjectMemberResponseDto findOneMember(String projectId, String memberId) {
        return projectMemberRepository.findOneByProjectIdAndMemberId(projectId, memberId)
                .map(projectMemberMapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException("Member does not exist in this project"));
    }

    @Transactional
    public String deleteProjectMember(String projectId, String memberId) {
        projectMemberRepository.deleteByProjectIdAndMemberId(projectId, memberId);
        return "Project member has been removed.";
    }
}
