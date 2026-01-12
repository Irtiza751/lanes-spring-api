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

import java.util.List;
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

        Project project = projectRepository.findById(issueDto.getProjectId())
                .orElseThrow(() -> new EntityNotFoundException("Project does not exist!"));

        User assignee = null;
        if(Objects.nonNull(issueDto.getAssigneeId())) {
            assignee = userRepository.findById(issueDto.getAssigneeId())
                    .orElseThrow(() -> new EntityNotFoundException("User does not exist!"));
        }


        Sprint sprint = null;
        if(Objects.nonNull(issueDto.getSprintId())) {
            sprint = sprintRepository.findById(issueDto.getSprintId())
                    .orElseThrow(() -> new EntityNotFoundException("Sprint does not exist!"));
        }

        Status status = null;
        if(Objects.nonNull(issueDto.getStatusId())) {
            status = statusRepository.findById(issueDto.getStatusId())
                    .orElseThrow(() -> new EntityNotFoundException("Status does not exist!"));
        }

        Issue parent = null;
        if(Objects.nonNull(issueDto.getParentId())) {
            parent = issueRepository.findById(issueDto.getParentId())
                    .orElseThrow(() -> new EntityNotFoundException("Parent does not exist!"));
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

    public IssueResponseDto update(String issueId, CreateIssueDto issueDto) {
        Issue issue = issueRepository.findById(issueId)
                .orElseThrow(() -> new EntityNotFoundException("Issue does not exist!"));

        issueMapper.updateIssue(issueDto, issue);
        Issue savedIssue = issueRepository.save(issue);
        return issueMapper.toDto(savedIssue);
    }

    public List<IssueResponseDto> findByProject(String id) {
        return issueRepository.findByProjectId(id)
                .stream()
                .map(issueMapper::toDto)
                .toList();
    }

    public IssueResponseDto findById(String id) {
        return issueRepository.findById(id)
                .map(issueMapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException("Issue does not exist!"));
    }

    public String delete(String id) {
        issueRepository.deleteById(id);
        return "Issue deleted successfully";
    }
}
