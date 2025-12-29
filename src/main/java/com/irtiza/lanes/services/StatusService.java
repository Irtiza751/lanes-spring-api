package com.irtiza.lanes.services;

import com.irtiza.lanes.dtos.CreateStatusDto;
import com.irtiza.lanes.dtos.StatusResponseDto;
import com.irtiza.lanes.mappers.StatusMapper;
import com.irtiza.lanes.models.Project;
import com.irtiza.lanes.models.Status;
import com.irtiza.lanes.repositories.ProjectRepository;
import com.irtiza.lanes.repositories.StatusRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StatusService {
    private final StatusRepository statusRepository;
    private final ProjectRepository projectRepository;
    private final StatusMapper statusMapper;

    public StatusResponseDto create(CreateStatusDto createStatusDto) {
        Project project = projectRepository.findById(createStatusDto.getProjectId())
                .orElseThrow(() -> new EntityNotFoundException("Project not found"));
        // creating status object
        Status status = Status.builder()
                .project(project)
                .name(createStatusDto.getName())
                .category(createStatusDto.getCategory())
                .position(createStatusDto.getPosition())
                .build();
        // saving the new status
        Status savedStatus = statusRepository.save(status);
        return statusMapper.toDto(savedStatus);
    }

    public StatusResponseDto update(String statusId, CreateStatusDto statusDto) {
        Status status = statusRepository.findById(statusId)
                .orElseThrow(() -> new EntityNotFoundException("Status not found"));

        statusMapper.updateStatus(statusDto, status);
        Status updatedStatus = statusRepository.save(status);
        return statusMapper.toDto(updatedStatus);
    }

    public List<StatusResponseDto> find(String projectId) {
        return statusRepository.findAllByProjectId(projectId)
                .stream()
                .map(statusMapper::toDto)
                .toList();
    }

    public StatusResponseDto findOne(String projectId, String statusId) {
        return statusRepository.findByProjectIdAndId(projectId, statusId)
                .map(statusMapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException("Status not found"));
    }

    public String delete(String statusId) {
        statusRepository.deleteById(statusId);
        return "Status deleted";
    }
}
