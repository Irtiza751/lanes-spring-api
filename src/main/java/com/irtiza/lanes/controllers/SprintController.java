package com.irtiza.lanes.controllers;

import com.irtiza.lanes.dtos.CreateSprintDto;
import com.irtiza.lanes.dtos.SprintResponseDto;
import com.irtiza.lanes.services.SprintService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sprints")
@RequiredArgsConstructor
public class SprintController {
    private final SprintService sprintService;

    @PostMapping
    ResponseEntity<SprintResponseDto> createSprint(@RequestBody @Valid CreateSprintDto sprintDto) {
        return new ResponseEntity<>(sprintService.create(sprintDto), HttpStatus.CREATED);
    }

    @GetMapping("/{projectId}")
    ResponseEntity<List<SprintResponseDto>> findAllSprints(@PathVariable String projectId) {
        return ResponseEntity.ok(sprintService.findSprintByProject(projectId));
    }

    @GetMapping("/{sprintId}")
    ResponseEntity<SprintResponseDto> findOneSprint(@PathVariable String sprintId) {
        return ResponseEntity.ok(sprintService.findOneSprint(sprintId));
    }

    @DeleteMapping("/{sprintId}")
    ResponseEntity<String> deleteOneSprint(@PathVariable String sprintId) {
        return ResponseEntity.ok(sprintService.deleteSprint(sprintId));
    }
}
