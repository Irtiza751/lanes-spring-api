package com.irtiza.lanes.services;

import com.irtiza.lanes.dtos.CreateProjectDto;
import com.irtiza.lanes.dtos.ProjectResponseDto;
import com.irtiza.lanes.mappers.ProjectMapper;
import com.irtiza.lanes.models.Project;
import com.irtiza.lanes.models.User;
import com.irtiza.lanes.repositories.ProjectRepository;
import com.irtiza.lanes.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;
    private final ProjectMapper projectMapper;

    @Transactional
    public ProjectResponseDto create(CreateProjectDto projectDto) {
        String name = projectDto.getName();
        String projectKey = projectDto.getKey() == null || projectDto.getKey().isBlank()
                ? name.substring(0, Math.min(3, name.length())).toUpperCase()
                : projectDto.getKey().toUpperCase();

        User owner = userRepository.findById(projectDto.getOwnerId())
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        Project project = Project.builder()
                .name(projectDto.getName())
                .key(projectKey)
                .description(projectDto.getDescription())
                .owner(owner)
                .build();

        owner.add(project);
        Project savedProject = projectRepository.save(project);
        return projectMapper.toDto(savedProject);
    }

    public List<ProjectResponseDto> findAllByUserId(String ownerId){
        return projectRepository.findByOwnerId(ownerId)
                .stream()
                .map(projectMapper::toDto)
                .toList();
    }

    @Transactional
    public ProjectResponseDto update(String id, CreateProjectDto projectDto) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Project not found"));

        projectMapper.updateProjectFromDto(projectDto, project);
        Project savedProject = projectRepository.save(project);
        return projectMapper.toDto(savedProject);
    }

    public List<ProjectResponseDto> findAll() {
        return projectRepository.findAll()
                .stream()
                .map(projectMapper::toDto)
                .toList();
    }

    public void delete(String id) {
        projectRepository.deleteById(id);
    }
}
