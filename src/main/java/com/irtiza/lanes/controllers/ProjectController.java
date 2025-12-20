package com.irtiza.lanes.controllers;

import com.irtiza.lanes.dtos.CreateProjectDto;
import com.irtiza.lanes.dtos.ProjectResponseDto;
import com.irtiza.lanes.services.ProjectService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/projects")
@RequiredArgsConstructor
public class ProjectController {
    private final ProjectService projectService;


    @PostMapping
    ResponseEntity<ProjectResponseDto> createProject(@RequestBody @Valid CreateProjectDto projectDto) {
        return new ResponseEntity<>(projectService.create(projectDto), HttpStatus.CREATED);
    }

    @GetMapping
    ResponseEntity<List<ProjectResponseDto>> findAllProjects() {
        return ResponseEntity.ok(projectService.findAll());
    }

    @GetMapping("/{userId}")
    ResponseEntity<List<ProjectResponseDto>> findAllProjectsByUser(@PathVariable String userId) {
        return ResponseEntity.ok(projectService.findAllByUserId(userId));
    }

    @PutMapping("/{id}")
    ResponseEntity<ProjectResponseDto> updateProject(@PathVariable String id, @RequestBody @Valid CreateProjectDto projectDto) {
        return new ResponseEntity<>(projectService.update(id, projectDto), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<String> deleteProject(@PathVariable String id) {
        projectService.delete(id);
        return ResponseEntity.accepted().body("Project deleted successfully");
    }
}
