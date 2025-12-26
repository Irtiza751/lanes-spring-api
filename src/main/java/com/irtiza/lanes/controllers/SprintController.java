package com.irtiza.lanes.controllers;

import com.irtiza.lanes.dtos.CreateSprintDto;
import com.irtiza.lanes.dtos.SprintResponseDto;
import com.irtiza.lanes.dtos.UpdateSprintDto;
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

    @GetMapping("/{projectId}/{sprintId}")
    ResponseEntity<SprintResponseDto> findOneSprint(@PathVariable String projectId, @PathVariable String sprintId) {
        return ResponseEntity.ok(sprintService.findOneSprint(projectId, sprintId));
    }

    @PutMapping("/{sprintId}")
    ResponseEntity<SprintResponseDto> updateSprint(@PathVariable String sprintId, @RequestBody @Valid UpdateSprintDto sprintDto) {
        return ResponseEntity.ok(sprintService.update(sprintId, sprintDto));
    }

    @DeleteMapping("/{sprintId}")
    ResponseEntity<String> deleteSprint(@PathVariable String sprintId) {
        return ResponseEntity.ok(sprintService.delete(sprintId));
    }
}
