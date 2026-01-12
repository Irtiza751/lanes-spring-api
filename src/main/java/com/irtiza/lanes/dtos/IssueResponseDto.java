package com.irtiza.lanes.dtos;

import com.irtiza.lanes.enums.IssuePriority;
import com.irtiza.lanes.enums.IssueType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IssueResponseDto {
    private String id;
    private String title;
    private String description;
    private IssueType type;
    private Long issueNumber;
    private IssuePriority priority;
    private LocalDateTime dueDate;
    private LocalDateTime updatedAt;
    private LocalDateTime createdAt;
}
