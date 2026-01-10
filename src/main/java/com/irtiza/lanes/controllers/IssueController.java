package com.irtiza.lanes.controllers;

import com.irtiza.lanes.dtos.CreateIssueDto;
import com.irtiza.lanes.dtos.IssueResponseDto;
import com.irtiza.lanes.services.IssueService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/issues")
@RequiredArgsConstructor
public class IssueController {
    private final IssueService issueService;

    @PostMapping
    ResponseEntity<IssueResponseDto> create(@RequestBody @Valid CreateIssueDto issueDto) {
        return new ResponseEntity<>(issueService.create(issueDto), HttpStatus.CREATED);
    }
}
