package com.irtiza.lanes.controllers;

import com.irtiza.lanes.dtos.CreateStatusDto;
import com.irtiza.lanes.dtos.StatusResponseDto;
import com.irtiza.lanes.services.StatusService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/statuses")
@RequiredArgsConstructor
public class StatusController {
    private final StatusService statusService;

    @PostMapping
    ResponseEntity<StatusResponseDto> create(@RequestBody @Valid CreateStatusDto statusDto) {
        return new ResponseEntity<>(statusService.create(statusDto), HttpStatus.CREATED);
    }

    @GetMapping("/{projectId}")
    ResponseEntity<List<StatusResponseDto>> findAll(@PathVariable String projectId) {
        return ResponseEntity.ok(statusService.find(projectId));
    }

    @GetMapping("/{projectId}/{statusId}")
    ResponseEntity<StatusResponseDto> findOne(@PathVariable String projectId, @PathVariable String statusId) {
        return ResponseEntity.ok(statusService.findOne(projectId, statusId));
    }

    @PutMapping("/{statusId}")
    ResponseEntity<StatusResponseDto> updateOne(@PathVariable String statusId, @RequestBody @Valid CreateStatusDto statusDto) {
        return ResponseEntity.ok(statusService.update(statusId, statusDto));
    }

    @DeleteMapping("/{statusId}")
    ResponseEntity<String> deleteOne(@PathVariable String statusId) {
        return ResponseEntity.ok(statusService.delete(statusId));
    }
}
