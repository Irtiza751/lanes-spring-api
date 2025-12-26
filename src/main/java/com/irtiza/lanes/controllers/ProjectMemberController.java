package com.irtiza.lanes.controllers;

import com.irtiza.lanes.dtos.CreateProjectMemberDto;
import com.irtiza.lanes.dtos.ProjectMemberResponseDto;
import com.irtiza.lanes.services.ProjectMemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/projects/members")
@RequiredArgsConstructor
public class ProjectMemberController {
    private final ProjectMemberService projectMemberService;

    @PostMapping
    ResponseEntity<ProjectMemberResponseDto> addMember(@RequestBody @Valid CreateProjectMemberDto projectMemberDto) {
        return new ResponseEntity<>(projectMemberService.create(projectMemberDto), HttpStatus.CREATED);
    }

    @GetMapping
    ResponseEntity<List<ProjectMemberResponseDto>> findAllMembers() {
        return ResponseEntity.ok(projectMemberService.findAllMembers());
    }

    @GetMapping("/{projectId}")
    ResponseEntity<List<ProjectMemberResponseDto>> findAllByProjectId(@PathVariable String projectId) {
        return ResponseEntity.ok(projectMemberService.findAllMembersByProject(projectId));
    }

    @GetMapping("/{projectId}/{memberId}")
    ResponseEntity<ProjectMemberResponseDto> findOneMember(@PathVariable String projectId, @PathVariable String memberId) {
        return ResponseEntity.ok(projectMemberService.findOneMember(projectId, memberId));
    }

    @DeleteMapping("/{projectId}/{memberId}")
    ResponseEntity<String> deleteMember(@PathVariable String projectId, @PathVariable String memberId) {
        return ResponseEntity
                .accepted()
                .body(projectMemberService.deleteProjectMember(projectId, memberId));
    }
}
