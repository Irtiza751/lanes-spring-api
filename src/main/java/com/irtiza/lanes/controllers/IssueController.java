package com.irtiza.lanes.controllers;

import com.irtiza.lanes.dtos.CreateIssueDto;
import com.irtiza.lanes.dtos.IssueResponseDto;
import com.irtiza.lanes.services.IssueService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/issues")
@RequiredArgsConstructor
public class IssueController {
    private final IssueService issueService;

    @PostMapping
    ResponseEntity<IssueResponseDto> create(@RequestBody @Valid CreateIssueDto issueDto) {
        return new ResponseEntity<>(issueService.create(issueDto), HttpStatus.CREATED);
    }

    @GetMapping("/{projectId}")
    ResponseEntity<List<IssueResponseDto>> findIssues(@PathVariable String projectId) {
        return ResponseEntity.ok(issueService.findByProject(projectId));
    }

    @GetMapping("/{issueId}")
    ResponseEntity<IssueResponseDto> findById(@PathVariable String issueId) {
        return ResponseEntity.ok(issueService.findById(issueId));
    }

    @PatchMapping("/{issueId}")
    ResponseEntity<IssueResponseDto> update(@PathVariable String issueId, @RequestBody @Valid CreateIssueDto issueDto) {
        return ResponseEntity.ok(issueService.update(issueId, issueDto));
    }

    @DeleteMapping("/{issueId}")
    ResponseEntity<String> delete(@PathVariable String issueId) {
        return ResponseEntity.accepted().body(issueService.delete(issueId));
    }
}
