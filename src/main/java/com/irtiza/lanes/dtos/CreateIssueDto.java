package com.irtiza.lanes.dtos;

import com.irtiza.lanes.enums.IssuePriority;
import com.irtiza.lanes.enums.IssueType;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateIssueDto {
    @NotBlank(message = "title is required")
    private String title;

    @NotBlank(message = "description is required")
    private String description;
    // required ids
    private String sprintId;
    @NotBlank
    private String projectId;
    @NotBlank
    private String reporterId;
    // optional
    private LocalDateTime dueDate;
    private Long issueNumber;
    private IssuePriority priority;
    private IssueType type;
    private String statusId;
    private String assigneeId;
    private String parentId;
}
