package com.irtiza.lanes.controllers;

import com.irtiza.lanes.dtos.CreateProjectMemberDto;
import com.irtiza.lanes.dtos.ProjectMemberResponseDto;
import com.irtiza.lanes.services.ProjectMemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    ResponseEntity<?> findAllMembers() {
        return ResponseEntity.ok(projectMemberService.findAllMembers());
    }

    @GetMapping("/{ownerId}")
    ResponseEntity<?> findAllByOwnerId(@PathVariable String ownerId) {
        return ResponseEntity.ok(projectMemberService.findAllMembersByOwner(ownerId));
    }

    @DeleteMapping("/{memberId}")
    ResponseEntity<?> deleteMember(@PathVariable String memberId) {
        return null;
    }
}
