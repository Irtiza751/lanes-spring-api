package com.irtiza.lanes.controllers;

import com.irtiza.lanes.dtos.CreateLabelDto;
import com.irtiza.lanes.dtos.LabelResponseDto;
import com.irtiza.lanes.services.LabelService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/labels")
@RequiredArgsConstructor
public class LabelController {
    private final LabelService labelService;

    @PostMapping
    ResponseEntity<LabelResponseDto> create(@RequestBody @Valid CreateLabelDto labelDto) {
        return new ResponseEntity<>(labelService.create(labelDto), HttpStatus.CREATED);
    }

    @GetMapping("/{projectId}/")
    ResponseEntity<List<LabelResponseDto>> findAll(@PathVariable String projectId) {
        return ResponseEntity.ok(labelService.findAll(projectId));
    }

    @GetMapping("/{projectId}/{labelId}")
    ResponseEntity<LabelResponseDto> findOne(@PathVariable String projectId, @PathVariable String labelId) {
        return ResponseEntity.ok(labelService.findOne(projectId, labelId));
    }


    @PutMapping("/{labelId}")
    ResponseEntity<LabelResponseDto> update(@PathVariable String labelId, @RequestBody @Valid CreateLabelDto labelDto) {
        return ResponseEntity.accepted().body(labelService.update(labelId, labelDto));
    }

    @DeleteMapping("/{labelId}")
    ResponseEntity<String> delete(@PathVariable String labelId) {
        return ResponseEntity.accepted().body(labelService.delete(labelId));
    }
    
}
