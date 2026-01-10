package com.irtiza.lanes.services;

import com.irtiza.lanes.dtos.CreateIssueDto;
import com.irtiza.lanes.dtos.IssueResponseDto;
import com.irtiza.lanes.mappers.IssueMapper;
import com.irtiza.lanes.models.*;
import com.irtiza.lanes.repositories.*;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class IssueService {
    private final IssueRepository issueRepository;
    private final UserRepository userRepository;
    private final ProjectRepository projectRepository;
    private final SprintRepository sprintRepository;
    private final StatusRepository statusRepository;
//    private final LabelRepository labelRepository;
//    private final CommentRepository commentRepository;
    private final IssueMapper issueMapper;

    @Transactional
    public IssueResponseDto create(CreateIssueDto issueDto) {
        User reporter = userRepository.findById(issueDto.getReporterId())
                .orElseThrow(() -> new EntityNotFoundException("Reporter does not exist!"));

        User assignee = null;
        if(Objects.nonNull(issueDto.getAssigneeId())) {
            assignee = userRepository.findById(issueDto.getAssigneeId())
                    .orElse(null);
        }

        Project project = projectRepository.findById(issueDto.getProjectId())
                .orElseThrow(() -> new EntityNotFoundException("Project does not exist!"));

        Sprint sprint = null;
        if(Objects.nonNull(issueDto.getSprintId())) {
            sprint = sprintRepository.findById(issueDto.getSprintId())
                    .orElse(null);
        }

        Status status = null;
        if(Objects.nonNull(issueDto.getStatusId())) {
            status = statusRepository.findById(issueDto.getStatusId())
                    .orElse(null);
        }

        Issue parent = null;
        if(Objects.nonNull(issueDto.getParentId())) {
            parent = issueRepository.findById(issueDto.getParentId())
                    .orElse(null);
        }

        Issue issue = Issue.builder()
                .issueNumber(issueDto.getIssueNumber())
                .title(issueDto.getTitle())
                .description(issueDto.getDescription())
                .type(issueDto.getType())
                .priority(issueDto.getPriority())
                .dueDate(issueDto.getDueDate())
                .project(project)
                .sprint(sprint)
                .reporter(reporter)
                .assignee(assignee)
                .parent(parent)
                .status(status)
                .build();

        Issue savedIssue = issueRepository.save(issue);
        return issueMapper.toDto(savedIssue);
    }
}
