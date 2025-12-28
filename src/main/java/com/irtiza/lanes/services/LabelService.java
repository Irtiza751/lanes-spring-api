package com.irtiza.lanes.services;

import com.irtiza.lanes.dtos.CreateLabelDto;
import com.irtiza.lanes.dtos.LabelResponseDto;
import com.irtiza.lanes.mappers.LabelMapper;
import com.irtiza.lanes.models.Label;
import com.irtiza.lanes.models.Project;
import com.irtiza.lanes.repositories.LabelRepository;
import com.irtiza.lanes.repositories.ProjectRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LabelService {
    private final LabelRepository labelRepository;
    private final ProjectRepository projectRepository;
    private final LabelMapper labelMapper;

    public LabelResponseDto create(CreateLabelDto createLabelDto) {
        Project project = projectRepository.findById(createLabelDto.getProjectId())
                .orElseThrow(() -> new EntityNotFoundException("Project not found"));

        Label label = Label.builder()
                .project(project)
                .color(createLabelDto.getColor())
                .name(createLabelDto.getName())
                .build();

        Label savedLabel = labelRepository.save(label);
        return labelMapper.toDto(savedLabel);
    }

    public LabelResponseDto update(String labelId, CreateLabelDto createLabelDto) {
        Label label = labelRepository.findById(labelId)
                .orElseThrow(() -> new EntityNotFoundException("Project not found"));

        labelMapper.updateLabel(createLabelDto, label);
        // persisting the updated label
        Label savedLabel = labelRepository.save(label);
        return labelMapper.toDto(savedLabel);
    }

    public List<LabelResponseDto> findAll(String projectId) {
        return labelRepository.findAllByProjectId(projectId)
                .stream()
                .map(labelMapper::toDto)
                .toList();
    }

    public LabelResponseDto findOne(String projectId, String labelId) {
        return labelRepository.findByProjectIdAndId(projectId, labelId)
                .map(labelMapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException("Label not found"));
    }

    public String delete(String labelId) {
        labelRepository.deleteById(labelId);
        return "Label has ben deleted";
    }
}
