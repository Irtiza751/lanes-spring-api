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
public class CreateIssueDto {
    private String title;
    private String description;
    private Long issueNumber;
    private LocalDateTime dueDate;
    private LocalDateTime updatedAt;
    private LocalDateTime createdAt;
    // required ids
    private String sprintId;
    private String projectId;
    private String reporterId;
    // optional
    private IssuePriority priority;
    private IssueType type;
    private String statusId;
    private String assigneeId;
    private String parentId;
}
