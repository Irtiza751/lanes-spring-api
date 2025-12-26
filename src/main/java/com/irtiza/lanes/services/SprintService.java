package com.irtiza.lanes.services;

import com.irtiza.lanes.dtos.CreateSprintDto;
import com.irtiza.lanes.dtos.SprintResponseDto;
import com.irtiza.lanes.dtos.UpdateSprintDto;
import com.irtiza.lanes.mappers.SprintMapper;
import com.irtiza.lanes.models.Project;
import com.irtiza.lanes.models.Sprint;
import com.irtiza.lanes.repositories.ProjectRepository;
import com.irtiza.lanes.repositories.SprintRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SprintService {
    private final SprintRepository sprintRepository;
    private final ProjectRepository projectRepository;
    private final SprintMapper sprintMapper;

    @Transactional
    public SprintResponseDto create(CreateSprintDto createSprintDto) {
        Project project = projectRepository.findById(createSprintDto.getProjectId())
                .orElseThrow(() -> new EntityNotFoundException("Project not found"));
        // create sprint
        Sprint sprint = Sprint.builder()
                .name(createSprintDto.getName())
                .isActive(createSprintDto.getIsActive())
                .startDate(createSprintDto.getStartDate())
                .endDate(createSprintDto.getEndDate())
                .project(project)
                .build();

        Sprint savedSprint = sprintRepository.save(sprint);
        return sprintMapper.toDto(savedSprint);
    }

    public List<SprintResponseDto> findSprintByProject(String projectId) {
        return sprintRepository.findAllByProjectId(projectId)
                .stream()
                .map(sprintMapper::toDto)
                .toList();
    }

    public SprintResponseDto findOneSprint(String projectId, String sprintId) {
        return sprintRepository.findByProjectIdAndId(projectId, sprintId)
                .map(sprintMapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException("Sprint not found"));
    }

    @Transactional
    public String delete(String sprintId) {
        sprintRepository.deleteById(sprintId);
        return  "Sprint has been deleted";
    }

    @Transactional
    public SprintResponseDto update(String sprintId, UpdateSprintDto sprintDto) {
        Sprint sprint = sprintRepository.findById(sprintId)
                .orElseThrow(() -> new EntityNotFoundException("Sprint not found"));

        sprintMapper.updateSprint(sprintDto, sprint);
        Sprint updatedSprint = sprintRepository.save(sprint);
        return sprintMapper.toDto(updatedSprint);
    }
}
